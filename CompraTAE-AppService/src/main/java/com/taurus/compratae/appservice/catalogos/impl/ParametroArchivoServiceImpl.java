/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.ParametroArchivoService;
import com.taurus.compratae.db.dto.ParametroArchivo;
import com.taurus.compratae.db.service.ParametroArchivoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("parametroArchivoService")
@Transactional
public class ParametroArchivoServiceImpl implements ParametroArchivoService {

    @Autowired
    private ParametroArchivoDbService parametroArchivoDbService;
    
    @Override
    public ParametroArchivo buscarPorNombre(String nombre) {
        return parametroArchivoDbService.buscarPorNombre(nombre);
    }
    
}
