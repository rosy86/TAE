/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos;

import com.taurus.compratae.db.dto.Monto;

/**
 *
 * @author Desarrollador java
 */
public interface MontoService {
    public Monto buscarPorMonto(Integer monto);
}
