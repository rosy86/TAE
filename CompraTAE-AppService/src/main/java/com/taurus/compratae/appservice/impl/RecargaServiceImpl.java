/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.compratae.appservice.GeneracionArchivoConciliacionService;
import com.taurus.compratae.appservice.catalogos.CadenaService;
import com.taurus.compratae.appservice.catalogos.FolioService;
import com.taurus.compratae.appservice.catalogos.MontoService;
import com.taurus.compratae.appservice.catalogos.ProveedorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.taurus.compratae.appservice.RecargaService;
import com.taurus.compratae.appservice.catalogos.RespuestaService;
import com.taurus.compratae.appservice.catalogos.TerminalService;
import com.taurus.compratae.appservice.catalogos.TiendaService;
import com.taurus.compratae.appservice.TransaccionService;
import com.taurus.compratae.appservice.exception.ErrorTAEException;
import com.taurus.compratae.appservice.exception.ValidacionException;
import com.taurus.compratae.appservice.hilos.ConsultaRecargaHilo;
import com.taurus.compratae.appservice.hilos.RecargaSaldoHilo;
import com.taurus.compratae.db.dto.Cadena;
import com.taurus.compratae.db.dto.Folio;
import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.dto.Respuesta;
import com.taurus.compratae.db.dto.Terminal;
import com.taurus.compratae.db.dto.Tienda;
import com.taurus.compratae.db.dto.Transaccion;
import com.taurus.compratae.db.service.ArchivoDbService;
import com.taurus.tae.wsclient.RespuestaRecarga;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rosy
 */
@Service("recargaService")
@Transactional
public class RecargaServiceImpl implements RecargaService {

    private static final Log log = LogFactory.getLog(RecargaService.class);
    @Autowired
    ArchivoDbService archivoDbService;

    @Autowired
    CadenaService cadenaService;
    @Autowired
    TiendaService tiendaService;
    @Autowired
    TerminalService terminalService;
    @Autowired
    FolioService folioService;
    @Autowired
    TransaccionService transaccionService;
    @Autowired
    ProveedorService proveedorService;
    @Autowired
    MontoService montoService;
    @Autowired
    RespuestaService respuestaService;
    @Autowired
    GeneracionArchivoConciliacionService  generacionArchivoConciliacionService;

    //Los valores a buscar, lo hacemos asi porque por el momento solo hay una cadena y tienda y terminal son libres y no se pueden elegir desde la pantalla.
    String CODIGO_CADENA = "39";
    static final Integer ID_TIENDA = 1;
    static final Integer ID_TERMINAL = 1;
    static final String CODIGO_DESCONOCIDO = "DE";
    String CODIGO_PRUEBA = "7";//Este se debe de ir!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    int tiempoTranscurrido = 0;

    public void validarDatos(String proveedor, String monto, String telefono1, String telefono2) throws ValidacionException {

        if(proveedor == null || proveedor.isEmpty() || proveedor.equals("")) {
            throw new ValidacionException("Se debe seleccionar proveedor.");
        }
        if(monto == null || monto.isEmpty() || monto.equals("")) {
            throw new ValidacionException("Se debe seleccionar el monto.");
        }
        if (telefono1 == null || telefono1.isEmpty() || telefono1.equals("")) {
            throw new ValidacionException("Ingresar número móvil.");
        }
        if (telefono2 == null || telefono2.isEmpty() || telefono2.equals("")) {
            throw new ValidacionException("Se requiere confirmación del teléfono.");
        }
        if (!telefono1.equals(telefono2)) {
            throw new ValidacionException("Los teléfonos deben ser iguales.");
        } else if (telefono1.length() < 10) {
           throw new ValidacionException("La longitud del nómero teléfonico debe ser de 10 digitos.");
        }
    }
    @Override
    public String realizarRecargarTAE(String proveedor, String monto, String telefono1, String telefono2) throws ValidacionException, ErrorTAEException {

        //Validar numero telefonico (igual y no menor de 10 digitos)
        validarDatos(proveedor, monto, telefono1, telefono2);
        //Obtener de momento el proveedor y monto en base a los datos recibidos
        Monto montoDTO = montoService.buscarPorMonto(Integer.valueOf(monto));
        Proveedor proveedorDTO = proveedorService.buscarPorNombre(proveedor);

        //Obtencion de cadena, tienda y terminal
        Cadena cadenaDTO = cadenaService.buscarPorCodigo(CODIGO_CADENA);
        Tienda tiendaDTO = tiendaService.buscarPorIdTienda(ID_TIENDA);
        Terminal terminalDTO = terminalService.buscarPorIdTerminal(ID_TERMINAL);

        //Obtener nuevo folio de la base de datos        
        Folio nuevoFolio = folioService.obtenerUltimoFolio();
        //Guardamos la transaccion en la bd
        Date fecha = new Date();
        Transaccion transaccion = transaccionService.guardar(cadenaDTO, tiendaDTO, terminalDTO, nuevoFolio,
                fecha, proveedorDTO, montoDTO, telefono2, 0);
        //manejar peticiones maneja todo el flujo que debe seguir el proceso para realizar la recarga.
        String respuesta = manejarPeticiones(transaccion);
        return respuesta;
    }

    public String manejarPeticiones(Transaccion transaccion) throws ErrorTAEException {
        if (transaccion.getIntento() < 2) {
            //espera 60 segundos
            RespuestaRecarga respRec = hiloRecargaSaldo(60, transaccion); // 1, 2
            //respRec = null; //// Quitar!!!!!!!!!!!! (Solo para pruebas)
            //fin de los 60 segundos
            //if(transaccion.getIntento()==1){
            //  respRec = null;                
            // }
            if (respRec == null) {
                for (int i = 0; i <= 60; i += 2) {
                    //esperar dos segundos
                    respRec = hiloConsultaRecarga(2, transaccion);// 3.1
                    //respRec = null; //// Quitar!!!!!!!!!!!! (Solo para pruebas)
                    //fin de 2 segundos
                    if (respRec != null) {
                        //validar respuesta
                        int codigoRespuesta = respRec.getResponseCode();
                        Respuesta respuestaObtenida = buscarRespuestaObtenida(codigoRespuesta);
                        if (respuestaObtenida.isExito()) {//Exitosa, generar archivo y actualizar transaccion
                            transaccion.setAutorizacion(respRec.getAutorizacion());
                            transaccion.setIdRespuesta(respuestaObtenida);
                            transaccion.setLeyendaticket1(respRec.getLeyendaTicket1());
                            transaccion.setLeyendaticket2(respRec.getLeyendaTicket2());
                            transaccion.setVigencia(Integer.valueOf(respRec.getVigencia()));
                            generarArchivo(transaccion);
                            transaccionService.guardarTransaccion(transaccion);
                            generarTicket(transaccion);
                            return respuestaObtenida.getDescripcion();
                        } else {
                            //espera 60 segundos
                            respRec = hiloRecargaSaldo(60, transaccion); // 4
                            //fin de los 60 segundos
                            if (respRec != null) {//Si recibió respuesta
                                codigoRespuesta = respRec.getResponseCode();
                                respuestaObtenida = buscarRespuestaObtenida(codigoRespuesta);
                                if (respuestaObtenida.isExito()) {//Exitosa, generar archivo y actualizar transaccion
                                    transaccion.setAutorizacion(respRec.getAutorizacion());
                                    transaccion.setIdRespuesta(respuestaObtenida);
                                    transaccion.setLeyendaticket1(respRec.getLeyendaTicket1());
                                    transaccion.setLeyendaticket2(respRec.getLeyendaTicket2());
                                    transaccion.setVigencia(Integer.valueOf(respRec.getVigencia()));
                                    generarArchivo(transaccion);
                                    transaccionService.guardarTransaccion(transaccion);
                                    generarTicket(transaccion);
                                    return respuestaObtenida.getDescripcion();
                                } else {
                                    //solo actualizar transaccion
                                    transaccion.setIdRespuesta(respuestaObtenida);
                                    transaccionService.guardarTransaccion(transaccion);
                                    throw new ErrorTAEException(respuestaObtenida.getDescripcion());
                                    //return respuestaObtenida.getDescripcion();                                    
                                }
                            } else {
                                //No se recibió respuesta, solo actualizar transaccion
                                transaccion.setIdRespuesta(respuestaObtenida);
                                transaccionService.guardarTransaccion(transaccion);
                                throw new ErrorTAEException(respuestaObtenida.getDescripcion());
                                //return respuestaObtenida.getDescripcion();// Validar respuesta de "Sin conexion o algo similar??
                            }
                        }
                    }
                }
            } else {
                int codigoRespuesta = respRec.getResponseCode();
                Respuesta respuestaObtenida = buscarRespuestaObtenida(codigoRespuesta);
                if (respuestaObtenida.isExito()) {//Exitosa, generar archivo y actualizar transaccion
                    transaccion.setAutorizacion(respRec.getAutorizacion());
                    transaccion.setIdRespuesta(respuestaObtenida);
                    transaccion.setLeyendaticket1(respRec.getLeyendaTicket1());
                    transaccion.setLeyendaticket2(respRec.getLeyendaTicket2());
                    transaccion.setVigencia(Integer.valueOf(respRec.getVigencia()));
                    generarArchivo(transaccion);
                    transaccionService.guardarTransaccion(transaccion);
                    generarTicket(transaccion);
                    return respuestaObtenida.getDescripcion();
                } else if (respuestaObtenida.isErrorCheck()) {
                    //esperar 60 segundos
                    respRec = hiloConsultaRecarga(60, transaccion); // 3.2
                    //respRec = null;//QUITAR!!!!!!!!!! (solo para pruebas) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    //fin de 60 segundos
                    if (respRec == null) {
                        //actualizar transaccion
                        transaccion.setIdRespuesta(respuestaObtenida);// Validar respuesta de Sin conexion o algo similar??
                        transaccionService.guardarTransaccion(transaccion);
                        throw new ErrorTAEException(respuestaObtenida.getDescripcion());
                        //return respuestaObtenida.getDescripcion();
                    } else {
                        //es exitosa??
                        codigoRespuesta = respRec.getResponseCode();
                        respuestaObtenida = buscarRespuestaObtenida(codigoRespuesta);
                        if (respuestaObtenida.isExito()) {//Exitosa, generar archivo y actualizar transaccion
                            transaccion.setAutorizacion(respRec.getAutorizacion());
                            transaccion.setIdRespuesta(respuestaObtenida);
                            transaccion.setLeyendaticket1(respRec.getLeyendaTicket1());
                            transaccion.setLeyendaticket2(respRec.getLeyendaTicket2());
                            transaccion.setVigencia(Integer.valueOf(respRec.getVigencia()));
                            generarArchivo(transaccion);
                            transaccionService.guardarTransaccion(transaccion);
                            generarTicket(transaccion);
                            return respuestaObtenida.getDescripcion();
                        } else {
                            //si no es exitosa 
                            //espera 60 segundos
                            respRec = hiloRecargaSaldo(60, transaccion); // 4
                            //fin de los 60 segundos
                            codigoRespuesta = respRec.getResponseCode();
                            respuestaObtenida = buscarRespuestaObtenida(codigoRespuesta);
                            //es exitosa??
                            if (respuestaObtenida.isExito()) {//Exitosa, generar archivo y actualizar transaccion
                                //generar archivo y actualizar transaccion
                                transaccion.setAutorizacion(respRec.getAutorizacion());
                                transaccion.setIdRespuesta(respuestaObtenida);
                                transaccion.setLeyendaticket1(respRec.getLeyendaTicket1());
                                transaccion.setLeyendaticket2(respRec.getLeyendaTicket2());///Truena al hacer el integer.ValueOf de Vigencia
                                transaccion.setVigencia(Integer.valueOf(respRec.getVigencia()));
                                generarArchivo(transaccion);
                                transaccionService.guardarTransaccion(transaccion);
                                generarTicket(transaccion);
                                return respuestaObtenida.getDescripcion();
                            } else {
                                //si no es exitosa solo actualizar transaccion
                                transaccion.setIdRespuesta(respuestaObtenida);
                                transaccionService.guardarTransaccion(transaccion);
                                //return respuestaObtenida.getDescripcion();
                                throw new ErrorTAEException(respuestaObtenida.getDescripcion());
                            }
                        }
                    }
                }//Si no es codigo error = 8
                //llamar a esta misma funcion con la misma transaccion pero actualizada
                else {
                    int intento = transaccion.getIntento();
                    intento++;
                    transaccion.setIntento(intento);
                    transaccion.setIdRespuesta(respuestaObtenida);
                    transaccion = transaccionService.guardarTransaccion(transaccion);
                    if(intento >= 2){
                        throw new ErrorTAEException(respuestaObtenida.getDescripcion());
                    }else {                    
                        String resultado = manejarPeticiones(transaccion);
                        return resultado;
                    }

                }
            }
        } else {
            return transaccion.getIdRespuesta().getDescripcion();//Realmente, nunca se llega aquí, ya que al segundo intento fallido, se lanza excepción.
        }
        throw new ErrorTAEException((respuestaService.buscarPorCodigo(CODIGO_DESCONOCIDO)).getDescripcion());//No se llega a este punto, pero el código lo pide
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Respuesta buscarRespuestaObtenida(int codigoRespuesta) {
        Respuesta respuesta = respuestaService.buscarPorCodigo(String.valueOf(codigoRespuesta));// aquí debe ir codigoRespuesta como parametro, si hay otra cosa, cambiar!!
        if (respuesta == null) {
            respuesta = respuestaService.buscarPorCodigo(CODIGO_DESCONOCIDO);
        }
        return respuesta;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String generarTicket(Transaccion transaccion) {

        String ticket;
        ticket = "Teléfono: " +  transaccion.getTelefono();
        ticket +=  "\n";
        ticket += "Monto: " +  transaccion.getIdMonto();
        ticket +=  "\n";
        ticket += "Vigencia: " + transaccion.getVigencia() ;
        ticket +=  "\n";
        ticket += "Nota: " +  transaccion.getLeyendaticket1();
        ticket +=  "\n";
        ticket += transaccion.getLeyendaticket2();
        ticket +=  "\n";
        return ticket;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void generarArchivo(Transaccion transaccion) throws ErrorTAEException {
        //generar archivo con el formato correcto. Después llamar a guardarDatos.
        generacionArchivoConciliacionService.generarArchivo(transaccion);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public RespuestaRecarga hiloRecargaSaldo(int segundos, Transaccion transaccion) {
        RecargaSaldoHilo hilo = new RecargaSaldoHilo(transaccion);
        hilo.start();
        synchronized (hilo) {
            try {
                System.out.println("Waiting for hilo hiloRecargaSaldo to complete...");
                hilo.wait(segundos * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ya terminó el hilo hiloRecargaSaldo...");
        }
        return hilo.respuestaRecarga;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public RespuestaRecarga hiloConsultaRecarga(int segundos, Transaccion transaccion) {
        ConsultaRecargaHilo hilo = new ConsultaRecargaHilo(transaccion);
        hilo.start();
        synchronized (hilo) {
            try {
                System.out.println("Waiting for hilo hiloConsultaRecarga to complete...");
                hilo.wait(segundos * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Ya terminó el hilo hiloConsultaRecarga...");
        }
        return hilo.respuestaRecarga;
    }
}
