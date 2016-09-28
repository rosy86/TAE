/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.tae.wsclient.RespuestaRecarga;
import java.net.Authenticator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Desarrollador java
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fecha = new Date();
        String fechaS = fecha.toString();
        System.out.println("Fecha: " + fechaS); 
        
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
        
        String formatoTotal1 = formatoHora.format(fecha) ;
        String formatoTotal2 = formatoFecha.format(fecha) ;
        String formatoTotal = formatoTotal2+ " " + formatoTotal1;
        System.out.println("Fecha con formato como es: " + formatoTotal);
        /*String idCadena = "39";
        String idTienda = "5";
        String idTerminal = "01";
        String folio = "12345";
        String fecha = "20110101 13:05:05";
        String telefono = "5512971063";
        String monto = "100";
        String proveedor = "01";*/
        //RespuestaRecarga respRec = recargaSaldo(idCadena, idTienda, idTerminal, folio, fecha, telefono, monto, proveedor);
        //System.out.println("Folio: " + respRec.getFolio());
    }

    private static RespuestaRecarga recargaSaldo(java.lang.String idCadena, java.lang.String idTienda, java.lang.String idTerminal, java.lang.String folio, java.lang.String fecha, java.lang.String telefono, java.lang.String monto, java.lang.String proveedor) {
        
        //Authenticator.setDefault(new MiAutenticadorAppService());  
        com.taurus.tae.wsclient.WsTae_Service service = new com.taurus.tae.wsclient.WsTae_Service();
        com.taurus.tae.wsclient.WsTae port = service.getWsTaePort();
        return port.recargaSaldo(idCadena, idTienda, idTerminal, folio, fecha, telefono, monto, proveedor);
    }
}
