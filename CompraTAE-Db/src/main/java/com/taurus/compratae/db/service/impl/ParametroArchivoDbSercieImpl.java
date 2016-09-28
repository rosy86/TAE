/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.ParametroArchivo;
import com.taurus.compratae.db.repository.ParametroArchivoRepository;
import com.taurus.compratae.db.service.ParametroArchivoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("parametroArchivoDbService")
@Repository
public class ParametroArchivoDbSercieImpl implements ParametroArchivoDbService {
    
    @Autowired
    private ParametroArchivoRepository parametroArchivoRepository;

    @Override
    public ParametroArchivo buscarPorNombre(String nombre) {
        return parametroArchivoRepository.findByNombre(nombre);
    }
}
