/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.repository;
import com.taurus.compratae.db.dto.Archivo;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Desarrollador java
 */
public interface ArchivoRepository extends CrudRepository<Archivo, Integer> {
    public Archivo findByIdArchivo(Integer idArchivo);
    public Archivo findByFecha(Date fecha);
    public Archivo findByFechaBetween(Date fecha1, Date fecha2);
    
    public Archivo findByNombre(String nombre);
}
  