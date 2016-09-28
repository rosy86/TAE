/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.RespuestaService;
import com.taurus.compratae.db.dto.Respuesta;
import com.taurus.compratae.db.service.RespuestaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("respuestaService")
@Transactional
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    RespuestaDbService respuestaDbService;
    
    public Respuesta buscarPorCodigo(String codigo) {
        return respuestaDbService.buscarPorCodigo(codigo);
    }
    
}
