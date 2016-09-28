/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.repository;

import com.taurus.compratae.db.dto.Terminal;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Rosy
 */
public interface TerminalRepository extends CrudRepository<Terminal, Integer> {
    
}
