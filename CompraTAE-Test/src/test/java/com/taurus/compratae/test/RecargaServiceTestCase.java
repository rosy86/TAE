/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test;

import com.taurus.compratae.appservice.RecargaService;
import com.taurus.compratae.appservice.exception.RecargaTAEException;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class RecargaServiceTestCase extends TestCase {
    private static final Logger log = LoggerFactory.getLogger(RecargaServiceTestCase.class);
    private RecargaService recargaService;
    private ApplicationContext applicationContext;

    private void setup() {
        String[] contexts = {"spring-data-app-context.xml", "appservice-application.context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        recargaService = (RecargaService) applicationContext.getBean("recargaService");
    }
    public void testBuscarTodo() throws RecargaTAEException {
        log.debug("Inicio testRecarga");
        setup();
        String resultado = recargaService.realizarRecargarTAE("ALO", "50", "5528471938", "5528471938");
        System.out.println("Resultado: " + resultado);
        log.debug("Resultado: "+resultado);
        log.debug("Fin testRecarga");
    }
}
