/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Transaccion;
import com.taurus.compratae.db.repository.TransaccionRepository;
import com.taurus.compratae.db.service.TransaccionDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("transaccionDbService")
@Repository
public class TransaccionDbServiceImpl implements TransaccionDbService{
    
    @Autowired
    private TransaccionRepository transaccionRepository;

    public Transaccion guardar(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    @Override
    public Transaccion buscarPorId(Integer id) {
        return transaccionRepository.findOne(id);
    }
        
    
}
