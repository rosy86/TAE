/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test.dbservice;

import com.taurus.compratae.db.service.ArchivoDbService;
import org.slf4j.Logger;
import junit.framework.TestCase;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class ArchivoDbServiceTestCase extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(ArchivoDbServiceTestCase.class);
    private ArchivoDbService archivoDbService;
    private ApplicationContext applicationContext;

    private void setup() {
        String[] contexts = {"spring-data-app-context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        archivoDbService = (ArchivoDbService) applicationContext.getBean("archivoDbService");
    }

    public void testBuscarTodo() {
        log.debug("Inicio testBuscarTodo");
        setup();
        archivoDbService.buscarTodo();
        log.debug("Fin testBuscarTodo");
    }
}
