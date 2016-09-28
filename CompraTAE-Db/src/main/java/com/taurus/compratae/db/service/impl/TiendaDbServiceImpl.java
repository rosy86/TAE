/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Tienda;
import com.taurus.compratae.db.repository.TiendaRepository;
import com.taurus.compratae.db.service.TiendaDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("tiendaDbService")
@Repository
public class TiendaDbServiceImpl implements TiendaDbService {
    
    @Autowired
    private TiendaRepository tiendaRepository;

    public Tienda buscarPorIdTienda(Integer idTienda) {
        return tiendaRepository.findOne(idTienda);
    }
    
  
    
}
