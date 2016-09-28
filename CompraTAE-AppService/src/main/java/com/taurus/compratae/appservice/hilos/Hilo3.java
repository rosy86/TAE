/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.hilos;

import com.taurus.compratae.db.dto.Transaccion;


/**
 *
 * @author Desarrollador java
 */
public class Hilo3 {

    public static void main(String[] args) {

        Transaccion transaccion = new Transaccion();          
        RecargaSaldoHilo hilo1 = new RecargaSaldoHilo(transaccion);
        hilo1.start();
        
        synchronized(hilo1){
            try{
                System.out.println("Waiting for hilo1 to complete...");
                hilo1.wait(5000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("[Estoy en el main] Folio :" + hilo1.respuestaRecarga.getResponseDescription());
            System.out.println("Ya terminó el hileishon...");
        }
       

    }
}
