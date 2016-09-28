/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.compratae.appservice.ArchivoService;
import com.taurus.compratae.appservice.GeneracionArchivoConciliacionService;
import com.taurus.compratae.appservice.catalogos.ParametroArchivoService;
import com.taurus.compratae.appservice.exception.ErrorTAEException;
import com.taurus.compratae.appservice.util.FormatoFecha;
import com.taurus.compratae.db.dto.Archivo;
import com.taurus.compratae.db.dto.ParametroArchivo;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.dto.Transaccion;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("generacionArchivoConciliacionService")
@Transactional
public class GeneracionArchivoConciliacionServiceImpl implements GeneracionArchivoConciliacionService {

    static final String NOMBRE_ARCHIVO = "NOMBRE_ARCHIVO";//Nombre del parametro que contiene el nombre del archivo
    static final String INDICADOR_HEADER = "HEADER";//Nombre del parametro que contiene el inicio del header
    static final String INDICADOR_REG = "REGISTRO";//Nombre del parametro que contiene el inicio del header
    static final List<String> INDICADORES_REG = Arrays.asList("CONTADOR", "FECHA", "HORA", "AUTO", "TELEFONO", "PROVEEDOR", "MONTO", "TERMINAL_ID");
    static final String CONTADOR = "CONTADOR";
    static final String AUTORIZACION = "AUTO";
    static final String PROVEEDOR = "PROVEEDOR";
    static final String MONTO = "MONTO";
    static final String TERMINAL_ID = "TERMINAL_ID";
    static final String CADENA = "CADENA";
    static final String TIENDA = "TIENDA";
    static final String TERMINAL = "TERMINAL";
    static final String FOLIO = "FOLIO";
    static final String PATH = "PATH";
    static final String INDICADOR_FOOTER = "FOOTER";
    static final String NUM_REG = "NUM_REG";
    static final String TOTAL_VENTA = "TOTAL_VENTA";

    @Autowired
    private ArchivoService archivoService;
    @Autowired
    private ParametroArchivoService parametroArchivoService;

    @Override
    public void generarArchivo(Transaccion transaccion) throws ErrorTAEException {
        //Primero se debe validar que exista archivo para ese día
        //transaccion = transaccionDbService.buscarPorId(19);/////////////////////esto es para pruebas
        Date fecha = transaccion.getFecha();

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormtat = formatoDelTexto.format(fecha);

        Date fecha1 = null;

        try {
            fecha1 = formatoDelTexto.parse(fechaFormtat);
        } catch (ParseException ex) {
            //throw new ErrorTAEException(ex.getMessage());
        }

        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fecha1.getTime());
        cal.add(Calendar.MINUTE, 1439);
        Date fecha2 = new java.sql.Date(cal.getTimeInMillis());
        Archivo archivo = archivoService.buscarEntreFechas(fecha1, fecha2);

        //Si no existe, crear tanto registro en bd como el archivo en directorio y abrir el archivo
        if (archivo == null) {
            archivo = generarNuevo(fecha);//guardar nuevo registro en bd
            String cabecera = generarCabecera(archivo);
            guardarArchivo(archivo, cabecera, false);
        }
        //Generar String que contendrá línea a escribir en el archivo
        String linea = generarLineaRegistro(transaccion, archivo);
        //Ya existe (o existía), abrir archivo y escribir línea
        guardarArchivo(archivo, linea, true);
        //Actualizar registro de archivo, con numRegistos++ y archivo.montoTotal += transaccion.getMonto (hacerlo bien)
        int numRegistros = archivo.getNumregistros();
        numRegistros++;
        archivo.setNumregistros(numRegistros);
        int monto = transaccion.getIdMonto().getMonto();
        int total = archivo.getTotal();
        int totalActualizado = total + monto;
        archivo.setTotal(totalActualizado);
        archivoService.guardarNuevoArchivo(archivo);
        transaccion.setIdArchivo(archivo);
    }
    /*
    Este método genera un nuevo registro de archivo en la bd    
     */
    public Archivo generarNuevo(Date fecha) {
        Archivo nuevoArchivo = new Archivo();
        nuevoArchivo.setFecha(fecha);
        nuevoArchivo.setNumregistros(0);
        nuevoArchivo.setTotal(0);
        nuevoArchivo.setNombre(generarNombreArchivo(fecha));//Se genera el nombre que tendrá el archivo
        return archivoService.guardarNuevoArchivo(nuevoArchivo);
    }
    /*
    Generamos el nombre que tendrá el archivo
    */
    public String generarNombreArchivo(Date fecha) {
        String fechaParaNombre = FormatoFecha.formatearFechaArchivo(fecha);
        ParametroArchivo parametroArchivo = obtenerParametrosArchivo(PATH);
        //Aquí debería buscarse el path, para que se guarde en la tabla con todo y path 
        //y los demás métodos que buscan el nombre no tengan que buscar también el path.
        StringBuilder sbNombre = new StringBuilder(parametroArchivo.getValor());
        parametroArchivo = obtenerParametrosArchivo(NOMBRE_ARCHIVO);
        return (sbNombre.append(parametroArchivo.getValor()).append(fechaParaNombre).append(".txt")).toString();//+ fechaParaNombre + ".txt"
    }
    /*
    Guardamos el archivo en disco
    */
    public void guardarArchivo(Archivo archivo, String linea, boolean append) {
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            ParametroArchivo pathParam = obtenerParametrosArchivo(PATH);
            String path = pathParam.getValor();
            File directorio = new File(path);
            if(!directorio.exists()){
                directorio.mkdir();
            }
            String file = archivo.getNombre();
            File miArchivo = new File(file);

            fw = new FileWriter(file, append);//debo revisar la ruta en que se crea
            pw = new PrintWriter(fw);
            pw.println(linea);
        } catch (IOException ex) {
            Logger.getLogger(GeneracionArchivoConciliacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(GeneracionArchivoConciliacionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /*
    Genera el String el cual contiene la cabecera del archivo
    */
    public String generarCabecera(Archivo archivo) {
        ParametroArchivo parametroArchivo = obtenerParametrosArchivo(INDICADOR_HEADER);
        String fechaHeader = FormatoFecha.formatearFechaArchivoHeader(archivo.getFecha());
        return parametroArchivo.getValor() + fechaHeader;
    }
    /*
    Genera un String que contiene una línea de registro del archivo
    */
    public String generarLineaRegistro(Transaccion transaccion, Archivo archivo) {
        StringBuilder sb = new StringBuilder();
        ///////////Agregamos inicio de linea
        ParametroArchivo parArch = obtenerParametrosArchivo(INDICADOR_REG);
        sb.append(parArch.getValor());
        //Agregamos el resto de la linea, revisando si tienen que agregarse 0s o espacios
        //Contador
        parArch = obtenerParametrosArchivo(CONTADOR);
        int numReg = archivo.getNumregistros();
        numReg++;
        sb.append(validarRelleno(String.valueOf(numReg), parArch));
        ///Fecha y hora
        sb.append(FormatoFecha.formatearFechaArchivoRegistro(transaccion.getFecha()));
        ///Autorizacion
        parArch = obtenerParametrosArchivo(AUTORIZACION);
        sb.append(validarRelleno(transaccion.getAutorizacion(), parArch));
        //telefono
        sb.append(transaccion.getTelefono());
        //proveedor
        parArch = obtenerParametrosArchivo(PROVEEDOR);
        sb.append(validarRelleno(transaccion.getIdProveedor().getNombre(), parArch));
        //monto
        parArch = obtenerParametrosArchivo(MONTO);
        sb.append(validarRelleno(String.valueOf(transaccion.getIdMonto().getMonto()), parArch));
        //Terminal_ID (cadena, tienda, terminal, folio)
        parArch = obtenerParametrosArchivo(CADENA);
        sb.append(validarRelleno(transaccion.getIdCadena().getCodigo(), parArch));
        parArch = obtenerParametrosArchivo(TIENDA);
        sb.append(validarRelleno(transaccion.getIdTienda().getCodigo(), parArch));
        parArch = obtenerParametrosArchivo(TERMINAL);
        sb.append(validarRelleno(transaccion.getIdTerminal().getCodigo(), parArch));
        parArch = obtenerParametrosArchivo(FOLIO);
        sb.append(validarRelleno(transaccion.getIdFolio().getFolio(), parArch));

        return sb.toString();
    }
    /*
    Validamos si el campo a anexar requiere ser rellenada o completado
    */
    public String validarRelleno(String valor, ParametroArchivo parArch) {
        if (parArch.isRellenarconceros()) {
            return rellenarConCeros(parArch.getLongitudtotal(), valor, parArch.getDecimales());
        } else if (parArch.isRellenarconespacios()) {
            return rellenarConEspacios(parArch.getLongitudtotal(), valor);
        }
        return valor;
    }
    /*
    Método que rellena con ceros a la izquierda y agrega decimales si es necesario
    */
    public String rellenarConCeros(int longitud, String valor, int decimales) {
        int size = valor.length();
        int totalCeros = longitud - size - decimales;//se saca el número de ceros a agregar a la izquierda
        StringBuilder ceros = new StringBuilder();

        for (int i = 0; i < totalCeros; i++) {
            ceros.append("0");
        }
        StringBuilder tmp = new StringBuilder();
        tmp.append(ceros).append(valor);
        for (int i = 0; i < decimales; i++) {
            tmp.append("0");
        }
        return tmp.toString();
    }
    /*
    Método que rellena con espacios a la derecha
    */
    public String rellenarConEspacios(int longitud, String valor) {
        int size = valor.length();

        if (size > longitud) {
            valor = valor.substring(0, longitud);
            return valor;
        }
        int totalSpc = longitud - size;
        StringBuilder returnString = new StringBuilder(valor);

        for (int i = 0; i < totalSpc; i++) {
            returnString.append(" ");
        }
        return returnString.toString();
    }
    /*
    Obtiene un objeto de tipo ParametroArchivo de acuerdo al nombre
    */
    public ParametroArchivo obtenerParametrosArchivo(String parametro) {
        return parametroArchivoService.buscarPorNombre(parametro);
    }
    /*
    Genera el footer del archivo. Este método se ejecuta con el job, justo antes
    de colocar el archivo en el FTP
    */
    @Override
    public Archivo generarFooter() {
        //obtener fecha actual
        Date fecha = new Date();

        SimpleDateFormat format = new SimpleDateFormat("HH");
        String horaS = format.format(fecha);
        int hora = Integer.valueOf(horaS);
        String fechaNombre;
        
        ////LA SIGUIENTE CONDICION DEPENDE DE LA HORA EN QUE SE CORRA EL JOB//
        if (hora >= 0 && hora <= 20) {
            //buscar el de ayer
            Calendar cal = new GregorianCalendar();
            cal.setTimeInMillis(fecha.getTime());
            cal.add(Calendar.DATE, -1);
            Date fecha2 = new java.sql.Date(cal.getTimeInMillis());
            format = new SimpleDateFormat("ddMMyyyy");
            fechaNombre = format.format(fecha2);
        } else {
            //buscar el de hoy
            format = new SimpleDateFormat("ddMMyyyy");
            fechaNombre = format.format(fecha);
        }
        //////////////Esto es de prueba, quitar!!!!!!//////////
        
        format = new SimpleDateFormat("ddMMyyyy");
        fechaNombre = format.format(fecha);
        
        /////////////////////////////////////////////////////////
        ParametroArchivo paramArchivoNombre = obtenerParametrosArchivo(PATH);
        StringBuilder sb = new StringBuilder(paramArchivoNombre.getValor());
        paramArchivoNombre = obtenerParametrosArchivo(NOMBRE_ARCHIVO);
        sb.append(paramArchivoNombre.getValor());
        String nombreArchivo = (sb.append(fechaNombre).append(".txt")).toString();
        Archivo archivo = archivoService.buscarPorNombre(nombreArchivo);
        if (archivo != null) {
            String footer = generarLineaFooter(archivo);
            guardarArchivo(archivo, footer, true);
        }
        return archivo;
    }
    /*
    Generar un String que contiene la línea correspondiente al footer del archivo
    */
    public String generarLineaFooter(Archivo archivo) {
        ParametroArchivo parArch = obtenerParametrosArchivo(INDICADOR_FOOTER);
        StringBuilder sb = new StringBuilder(parArch.getValor());
        //---------------
        parArch = obtenerParametrosArchivo(NUM_REG);
        sb.append(validarRelleno(String.valueOf(archivo.getNumregistros()), parArch));
        //---------------
        parArch = obtenerParametrosArchivo(TOTAL_VENTA);
        sb.append(validarRelleno(String.valueOf(archivo.getTotal()), parArch));
        return sb.toString();
    }
}
