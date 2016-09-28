/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.compratae.appservice.ArchivoService;
import com.taurus.compratae.db.dto.Archivo;
import com.taurus.compratae.db.service.ArchivoDbService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("archivoService")
@Transactional
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoDbService archivoDbService;

    @Override
    public Archivo guardarNuevoArchivo(Archivo archivo) {
        return archivoDbService.guardarNuevoArchivo(archivo);
    }

    @Override
    public Archivo buscarEntreFechas(Date fecha1, Date fecha2) {
        return archivoDbService.buscarEntreFechas(fecha1, fecha2);
    }

    @Override
    public Archivo buscarPorNombre(String nombre) {
        return archivoDbService.buscarPorNombre(nombre);
    }

}
