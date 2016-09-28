/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service;

import com.taurus.compratae.db.dto.Monto;
import java.util.List;

/**
 *
 * @author Rosy
 */
public interface MontoDbService {
    
    public List<Monto> buscarTodo();
    public Monto buscarPorMonto(Integer monto);
    
}
