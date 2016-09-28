/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Respuesta;
import com.taurus.compratae.db.repository.RespuestaRepository;
import com.taurus.compratae.db.service.RespuestaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("respuestaDbService")
@Repository
public class RespuestaDbServiceImpl implements RespuestaDbService {
    
    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta buscarPorCodigo(String codigo) {
        return respuestaRepository.findByCodigo(codigo);
    }
}
