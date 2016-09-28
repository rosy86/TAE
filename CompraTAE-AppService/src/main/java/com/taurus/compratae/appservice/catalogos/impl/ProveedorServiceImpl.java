/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.ProveedorService;
import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.service.ProveedorDbService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("proveedorService")
@Transactional
public class ProveedorServiceImpl implements ProveedorService, Serializable{

    private static final long serialVersionUID = 1L;
    
    @Autowired
    private ProveedorDbService proveedorDbService;

    @Override
    public List<Proveedor> obtenerProveedores() {
        return proveedorDbService.buscarTodos();
    }

    @Override
    public Map<String,List<String>> obtenerProveedoresMonto() {
        List<Proveedor> listaPrv = proveedorDbService.buscarTodos();
        Map<String,List<String>> mapaString = new HashMap<String,List<String>>();
        for(Proveedor prv : listaPrv){
            List<Monto> montosTmp = (List<Monto>) prv.getMontoCollection();
            List<String> listaIntMonto = new ArrayList<String>();
            for(Monto monto : montosTmp) {
               listaIntMonto.add(String.valueOf(monto.getMonto()));
            }
            mapaString.put(prv.getNombre(),listaIntMonto);            
        }
        return mapaString;
    }

    @Override
    public Proveedor buscarPorNombre(String nombre) {
        return proveedorDbService.buscarPorNombre(nombre);
    }
    @Override
    public List<String> obtenerProveedoresString() {
        List<Proveedor> listaPrv = proveedorDbService.buscarTodos();
        List<String> listaNombres = new ArrayList<String>();
        for(Proveedor proveedor : listaPrv) {
            listaNombres.add(proveedor.getNombre());
        }
        return listaNombres;
    }
    public List<String> obtnenerProveedoresMonto(String nombre) {
        Proveedor proveedor = buscarPorNombre(nombre);
        List<Monto> montosTmp = (List<Monto>) proveedor.getMontoCollection();
        List<String> listaMonto = new ArrayList<String>();
        for(Monto monto : montosTmp){
            listaMonto.add(String.valueOf(monto.getMonto()));
        }
        return listaMonto;
    }
    
}
