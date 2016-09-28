/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice;

import com.taurus.compratae.db.dto.Archivo;
import java.util.Date;

/**
 *
 * @author Desarrollador java
 */
public interface ArchivoService {
    
    public Archivo guardarNuevoArchivo(Archivo archivo);
    public Archivo buscarEntreFechas(Date fecha1, Date fecha2);
    public Archivo buscarPorNombre(String nombre);
    
}
