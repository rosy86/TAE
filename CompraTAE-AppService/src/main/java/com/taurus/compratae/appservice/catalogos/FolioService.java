/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos;

import com.taurus.compratae.db.dto.Folio;
import java.util.List;

/**
 *
 * @author Desarrollador java
 */
public interface FolioService {
    
    public List<Folio> buscarTodos();
    public Folio guardar(Folio nuevoFolio);
    public Folio obtenerUltimoFolio();//Obtiene el último folio y lo aumenta. Devuelve el que se usará en la nueva transaccion
}
