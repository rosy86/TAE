/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service;

import com.taurus.compratae.db.dto.Transaccion;

/**
 *
 * @author Rosy
 */
public interface TransaccionDbService {
    
    public Transaccion guardar(Transaccion transaccion);
    public Transaccion buscarPorId(Integer id);
}
