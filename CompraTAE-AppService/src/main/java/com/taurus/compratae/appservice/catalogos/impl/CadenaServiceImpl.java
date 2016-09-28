/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.CadenaService;
import com.taurus.compratae.db.dto.Cadena;
import com.taurus.compratae.db.service.CadenaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("cadenaService")
@Transactional
public class CadenaServiceImpl implements CadenaService{

    @Autowired
    private CadenaDbService cadenaDbService;
           
    @Override
    public Cadena buscarPorCodigo(String codigo) {
        return cadenaDbService.buscarPorCodigo(codigo);
    }
    
}
