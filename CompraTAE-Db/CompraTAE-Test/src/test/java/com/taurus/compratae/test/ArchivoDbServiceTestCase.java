/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test;

import com.taurus.compratae.db.service.ArchivoDbService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class ArchivoDbServiceTestCase {
    private static final Logger log = LoggerFactory.getLogger(ArchivoDbServiceTestCase.class);
    private ArchivoDbService archivoDbService;
    private ApplicationContext applicationContext;
    public ArchivoDbServiceTestCase() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
                String[] contexts = {"spring-data-app-context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        archivoDbService = (ArchivoDbService) applicationContext.getBean("archivoDbService");

    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test 
    public void buscarTodo(){
        log.debug("Inicio testBuscarTodo");
        setUp();
        archivoDbService.buscarTodo();
        log.debug("Fin testBuscarTodo");
    }
}
