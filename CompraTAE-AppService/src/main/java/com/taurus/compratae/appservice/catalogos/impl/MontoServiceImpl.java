/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.MontoService;
import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.service.MontoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("montoService")
@Transactional
public class MontoServiceImpl implements MontoService{
    
    @Autowired
    private MontoDbService montoDbService;

    @Override
    public Monto buscarPorMonto(Integer monto) {
        return montoDbService.buscarPorMonto(monto);
    }

    
}
