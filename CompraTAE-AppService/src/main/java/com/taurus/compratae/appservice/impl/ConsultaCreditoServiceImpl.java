/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.compratae.appservice.ConsultaCreditoService;
import com.taurus.tae.wsclient.RespuestaCredito;
import com.tauruss.client.MiAutenticador;
import java.net.Authenticator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("consultaCreditoService")
@Transactional
public class ConsultaCreditoServiceImpl implements ConsultaCreditoService {

    public String consultarCredido() {
        RespuestaCredito  respuestaCredito = consultaCredito();
        String resultado = respuestaCredito.getResponseDescription() + " - " + respuestaCredito.getSaldo();
        return resultado;
        
    }
    private static RespuestaCredito consultaCredito() {
        Authenticator.setDefault(new MiAutenticador());
        com.taurus.tae.wsclient.WsTae_Service service = new com.taurus.tae.wsclient.WsTae_Service();
        com.taurus.tae.wsclient.WsTae port = service.getWsTaePort();
        return port.consultaCredito();
    }
    
}
