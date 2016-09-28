/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test;

import com.taurus.compratae.appservice.ConsultaCreditoService;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class ConsultaCreditoServiceTestCase extends TestCase {

    private static final Logger log = LoggerFactory.getLogger(ConsultaCreditoServiceTestCase.class);
    private ConsultaCreditoService consultaCreditoService;
    private ApplicationContext applicationContext;

    private void setup() {
        String[] contexts = {"spring-data-app-context.xml", "appservice-application.context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        consultaCreditoService = (ConsultaCreditoService) applicationContext.getBean("consultaCreditoService");
    }

    public void testConsultarCredito() {
        setup();
        String resultado = consultaCreditoService.consultarCredido();
        System.out.println("Resultado: " + resultado);
    }
}
