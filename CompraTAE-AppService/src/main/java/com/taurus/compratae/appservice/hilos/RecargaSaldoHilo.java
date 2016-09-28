/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.hilos;

import com.taurus.compratae.appservice.util.FormatoFecha;
import com.taurus.compratae.db.dto.Transaccion;
import com.taurus.tae.wsclient.RespuestaRecarga;
import com.tauruss.client.MiAutenticador;
import java.net.Authenticator;
/**
 *
 * @author Desarrollador java
 */
public class RecargaSaldoHilo extends Thread {

    public Transaccion transaccion;
    public RespuestaRecarga respuestaRecarga;

    public RecargaSaldoHilo(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    @Override
    public void run() {

        System.out.println("Entre al run de recargaSaldo");
        synchronized (this) {
            //respuestaRecarga = recargaSaldo("39", "5", "01", "12345", "20110101 11:49:55", "5528471938", "30", "15");
             respuestaRecarga = realizarPeticionWSRecargaSaldo(transaccion);
           // System.out.println("Folio: " + respuestaRecarga.getResponseDescription());
            notify();
        }
        System.out.println("Voy a finalizar run de recargaSaldo");
    }

    public RespuestaRecarga realizarPeticionWSRecargaSaldo(Transaccion transaccion) {
        String fecha = FormatoFecha.formatearFecha(transaccion.getFecha());
        /*
        RespuestaRecarga resRec = recargaSaldo(
                transaccion.getIdCadena().getCodigo(),
                transaccion.getIdCadena().getCodigo(),
                transaccion.getIdTerminal().getCodigo(),
                transaccion.getIdFolio().getFolio(),
                fecha,
                transaccion.getTelefono(),
                String.valueOf(transaccion.getIdMonto().getMonto()),
                transaccion.getIdProveedor().getCodigo());
        */        
        RespuestaRecarga resRec = recargaSaldo(
                transaccion.getIdCadena().getCodigo(),
                transaccion.getIdTienda().getCodigo(),
                transaccion.getIdTerminal().getCodigo(),
                transaccion.getIdFolio().getFolio(),
                fecha,
                transaccion.getTelefono(),
                String.valueOf(transaccion.getIdMonto().getMonto()),
                transaccion.getIdProveedor().getCodigo());
        return resRec;
    }
    private static RespuestaRecarga recargaSaldo(java.lang.String idCadena, java.lang.String idTienda, java.lang.String idTerminal, java.lang.String folio, java.lang.String fecha, java.lang.String telefono, java.lang.String monto, java.lang.String proveedor) {
        Authenticator.setDefault(new MiAutenticador());
        com.taurus.tae.wsclient.WsTae_Service service = new com.taurus.tae.wsclient.WsTae_Service();
        com.taurus.tae.wsclient.WsTae port = service.getWsTaePort();
        return port.recargaSaldo(idCadena, idTienda, idTerminal, folio, fecha, telefono, monto, proveedor);
    }
}
