/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.dto.Terminal;
import com.taurus.compratae.db.repository.TerminalRepository;
import com.taurus.compratae.db.service.TerminalDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("terminalDbService")
@Repository
public class TerminalDbServiceImpl implements TerminalDbService{
    
    @Autowired
    private TerminalRepository terminalRepository;

    public Terminal buscarPorIdTerminal(Integer idTerminal) {
        return terminalRepository.findOne(idTerminal);
    }
    
}
