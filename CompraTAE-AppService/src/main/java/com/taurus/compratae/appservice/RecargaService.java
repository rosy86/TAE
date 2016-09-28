/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice;

import com.taurus.compratae.appservice.exception.ErrorTAEException;
import com.taurus.compratae.appservice.exception.ValidacionException;

/**
 *
 * @author Rosy
 */
public interface RecargaService {
    
    public String realizarRecargarTAE(String proveedor, String monto, String telefono1, String telefono2) throws ValidacionException, ErrorTAEException;
    
}
