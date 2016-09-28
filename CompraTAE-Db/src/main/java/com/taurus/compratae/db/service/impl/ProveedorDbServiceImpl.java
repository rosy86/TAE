/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.repository.ProveedorRepository;
import com.taurus.compratae.db.service.ProveedorDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("proveedorDbService")
@Repository
public class ProveedorDbServiceImpl implements ProveedorDbService{
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    

    public List<Proveedor> buscarTodos() {
        return (List<Proveedor>) proveedorRepository.findAll();
    }

    public Proveedor buscarPorNombre(String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }
    
}
