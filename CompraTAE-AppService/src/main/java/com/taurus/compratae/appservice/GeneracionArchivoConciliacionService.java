/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice;

import com.taurus.compratae.appservice.exception.ErrorTAEException;
import com.taurus.compratae.db.dto.Archivo;
import com.taurus.compratae.db.dto.Transaccion;

/**
 *
 * @author Desarrollador java
 */
public interface GeneracionArchivoConciliacionService {

    public void generarArchivo(Transaccion transaccion) throws ErrorTAEException;
    public Archivo generarFooter();
}
