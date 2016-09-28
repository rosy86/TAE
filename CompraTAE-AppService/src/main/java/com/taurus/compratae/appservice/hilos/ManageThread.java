/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.hilos;

import com.taurus.tae.wsclient.RespuestaRecarga;
import com.tauruss.client.MiAutenticador;
import java.net.Authenticator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desarrollador java
 */
public class ManageThread {

    public ManageThread() {
    }
    
    public synchronized void manejarWait(){
        try{
            wait(60000);       
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ManageThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public synchronized void manejarNotify() {
            RespuestaRecarga respRec = recargaSaldo("39", "5", "01", "12345", "20110101 13:05:05", "5512971063", "100", "01");
            System.out.println("Folio: " + respRec.getFolio());
            notify();
        
    }
    private static RespuestaRecarga recargaSaldo(java.lang.String idCadena, java.lang.String idTienda, java.lang.String idTerminal, java.lang.String folio, java.lang.String fecha, java.lang.String telefono, java.lang.String monto, java.lang.String proveedor) {

        Authenticator.setDefault(new MiAutenticador());
        com.taurus.tae.wsclient.WsTae_Service service = new com.taurus.tae.wsclient.WsTae_Service();
        com.taurus.tae.wsclient.WsTae port = service.getWsTaePort();
        return port.recargaSaldo(idCadena, idTienda, idTerminal, folio, fecha, telefono, monto, proveedor);
    }
}
