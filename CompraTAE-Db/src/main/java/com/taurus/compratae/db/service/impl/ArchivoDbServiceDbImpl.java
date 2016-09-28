/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Archivo;
import com.taurus.compratae.db.repository.ArchivoRepository;
import com.taurus.compratae.db.service.ArchivoDbService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Desarrollador java
 */
@Service("archivoDbService")
@Repository
public class ArchivoDbServiceDbImpl implements ArchivoDbService{

    @Autowired
    private ArchivoRepository archivoRepository;
    
    @Override
    public Archivo buscarPorIdArchivo(Integer idArchivo) {
        return archivoRepository.findByIdArchivo(idArchivo);
    }

    @Override
    public Archivo guardarNuevoArchivo(Archivo arcchivo) {
        return archivoRepository.save(arcchivo);
    }

    @Override
    public Archivo buscarEntreFechas(Date fecha1, Date fecha2) {
        return archivoRepository.findByFechaBetween(fecha1, fecha2);
    }

    @Override
    public Archivo buscarPorNombre(String nombre) {
        return archivoRepository.findByNombre(nombre);
    }
    
}
