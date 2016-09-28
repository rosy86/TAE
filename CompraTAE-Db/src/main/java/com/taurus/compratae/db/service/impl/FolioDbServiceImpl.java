/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Folio;
import com.taurus.compratae.db.repository.FolioRepository;
import com.taurus.compratae.db.service.FolioDbService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("folioDbService")
@Repository
public class FolioDbServiceImpl implements FolioDbService {
    
    @Autowired
    private FolioRepository folioRepository;

    public List<Folio> buscarTodos() {
        return (List<Folio>) folioRepository.findAll();
    }

    public Folio guardar(Folio folio) {
        return folioRepository.save(folio);
    }
    
}
