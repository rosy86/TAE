/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.TiendaService;
import com.taurus.compratae.db.dto.Tienda;
import com.taurus.compratae.db.service.TiendaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("tiendaService")
@Transactional
public class TiendaServiceImpl implements TiendaService{

    @Autowired
    private TiendaDbService tiendaDbService;
    
    @Override
    public Tienda buscarPorIdTienda(Integer idTienda) {
        return tiendaDbService.buscarPorIdTienda(idTienda);
    }
    
}
