/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.service.impl;

import com.taurus.compratae.db.repository.ConsultaCreditoRepository;
import com.taurus.compratae.db.service.ConsultaCreditoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rosy
 */
@Service("consultaCreditoDbService")
@Repository
public class ConsultaCreditoDbServiceImpl implements ConsultaCreditoDbService {
    
    @Autowired
    private ConsultaCreditoRepository consultaCreditoRepository;
    
}
