/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.FolioService;
import com.taurus.compratae.db.dto.Folio;
import com.taurus.compratae.db.service.FolioDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("folioService")
@Transactional
public class FolioServiceImpl implements FolioService {

    @Autowired
    FolioDbService folioDbService;

    @Override
    public List<Folio> buscarTodos() {
        return folioDbService.buscarTodos();
    }

    @Override
    public Folio guardar(Folio nuevoFolio) {
        return folioDbService.guardar(nuevoFolio);
    }

    @Override
    public Folio obtenerUltimoFolio() {
        List<Folio> folios = folioDbService.buscarTodos();
        int numeroFolio = 1;
        if (folios != null && !folios.isEmpty()) {
            int count = folios.size();
            Folio folioUltimo = folios.get(count - 1);
            numeroFolio = Integer.valueOf(folioUltimo.getFolio());
            numeroFolio++;
        }
        //Salvamos el nuevo número de folio
        Folio nuevoFolio = new Folio();
        nuevoFolio.setFolio(String.valueOf(numeroFolio));
        
        return folioDbService.guardar(nuevoFolio);
    }

}
