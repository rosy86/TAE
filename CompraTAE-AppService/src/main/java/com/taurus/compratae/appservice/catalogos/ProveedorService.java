/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos;

import com.taurus.compratae.db.dto.Proveedor;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Desarrollador java
 */
public interface ProveedorService {
    
    public List<Proveedor> obtenerProveedores();
    public List<String> obtenerProveedoresString();
    public Map<String,List<String>> obtenerProveedoresMonto();
    public Proveedor buscarPorNombre(String nombre);
    public List<String> obtnenerProveedoresMonto(String nombre);
    
}
