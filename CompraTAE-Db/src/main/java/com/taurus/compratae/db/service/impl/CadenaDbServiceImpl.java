/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Cadena;
import com.taurus.compratae.db.repository.CadenaRepository;
import com.taurus.compratae.db.service.CadenaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("cadenaDbService")
@Repository
public class CadenaDbServiceImpl implements CadenaDbService{
    
    @Autowired
    private CadenaRepository cadenaRepository;

    public Cadena buscarPorCodigo(String codigo) {
        return cadenaRepository.findByCodigo(codigo);
    }
}
