/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.catalogos.impl;

import com.taurus.compratae.appservice.catalogos.TerminalService;
import com.taurus.compratae.db.dto.Terminal;
import com.taurus.compratae.db.service.TerminalDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("terminalService")
@Transactional
public class TerminalServiceImpl implements TerminalService {

    @Autowired
    private TerminalDbService terminalDbService;
    
    @Override
    public Terminal buscarPorIdTerminal(Integer idTerminal) {
        return terminalDbService.buscarPorIdTerminal(idTerminal);
    }
    
}
