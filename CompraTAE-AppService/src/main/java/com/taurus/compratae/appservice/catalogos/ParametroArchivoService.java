/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos;

import com.taurus.compratae.db.dto.ParametroArchivo;

/**
 *
 * @author Desarrollador java
 */
public interface ParametroArchivoService {
    public ParametroArchivo buscarPorNombre(String nombre);
}
