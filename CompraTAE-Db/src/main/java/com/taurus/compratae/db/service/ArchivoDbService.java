/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service;

import com.taurus.compratae.db.dto.Archivo;
import java.util.Date;

/**
 *
 * @author Desarrollador java
 */
public interface ArchivoDbService {
    public Archivo buscarPorIdArchivo(Integer idArchivo);
    public Archivo buscarEntreFechas(Date fecha1, Date fecha2);
    public Archivo guardarNuevoArchivo(Archivo arcchivo);
    public Archivo buscarPorNombre(String nombre);
}
