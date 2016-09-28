/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.repository.MontoRepository;
import com.taurus.compratae.db.service.MontoDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */

@Service("montooDbService")
@Repository
public class MontoDbServiceImpl implements MontoDbService{
    
    @Autowired
    private MontoRepository montoRepository;          


    public List<Monto> buscarTodo() {
        return (List<Monto>) montoRepository.findAll();
    }

    public Monto buscarPorMonto(Integer monto) {
        return montoRepository.findByMonto(monto);
    }

    
    
    
}
