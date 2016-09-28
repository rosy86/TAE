/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.model;

import java.io.Serializable;

/**
 *
 * @author Desarrollador java
 */
public class MontoM implements Serializable{
    
    private Integer idMonto;
    private int monto;

    public Integer getIdMonto() {
        return idMonto;
    }

    public void setIdMonto(Integer idMonto) {
        this.idMonto = idMonto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
    
    
}
