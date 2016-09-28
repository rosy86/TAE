/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test;

import com.taurus.compratae.appservice.EnvioArchivoFTPService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class EnvioArchivoFTPServiceTestCase extends TestCase{
    
    private EnvioArchivoFTPService envioArchivoFTPService;
    private ApplicationContext applicationContext;

    private void setup() {
        String[] contexts = {"spring-data-app-context.xml", "appservice-application.context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        envioArchivoFTPService = (EnvioArchivoFTPService) applicationContext.getBean("envioArchivoFTPService");
    }
    public void testEnvioArchivoFTP() {
        setup();
        envioArchivoFTPService.enviarArchivoFTP();
    }
    
}
