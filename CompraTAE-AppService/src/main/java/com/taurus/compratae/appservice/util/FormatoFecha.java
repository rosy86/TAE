/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Desarrollador java
 */
public class FormatoFecha {
    
    public static String formatearFecha(Date fecha) {

        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");

        String formatoTotal1 = formatoHora.format(fecha);
        String formatoTotal2 = formatoFecha.format(fecha);
        String fechaFormato = formatoTotal2 + " " + formatoTotal1;

        return fechaFormato;
    }
    public static String formatearFechaArchivo(Date fecha){
        DateFormat formatoFecha = new SimpleDateFormat("ddMMyyyy");
        String fechaFormato = formatoFecha.format(fecha);
        return fechaFormato;
    }
    public static String formatearFechaArchivoHeader(Date fecha){
        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
        String fechaFormato = formatoFecha.format(fecha);
        return fechaFormato;
    }
    public static String formatearFechaArchivoRegistro(Date fecha){
        DateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd");
        DateFormat formatoHora = new SimpleDateFormat("HHmmss");
        StringBuilder sb = new StringBuilder(formatoFecha.format(fecha));
        return (sb.append(formatoHora.format(fecha))).toString();
    }

}
