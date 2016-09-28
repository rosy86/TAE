/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test;

import com.taurus.compratae.appservice.GeneracionArchivoConciliacionService;
import com.taurus.compratae.appservice.TransaccionService;
import com.taurus.compratae.appservice.exception.ErrorTAEException;
import com.taurus.compratae.db.dto.Transaccion;
import com.taurus.compratae.db.service.TransaccionDbService;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class GeneracionArchivoServiceTestCase extends TestCase{
    
    private GeneracionArchivoConciliacionService generacionArchivoConciliacionService;
    private ApplicationContext applicationContext;
    private TransaccionService transaccionService;
    private TransaccionDbService transaccionDbService;

    private void setup() {
        String[] contexts = {"spring-data-app-context.xml", "appservice-application.context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        generacionArchivoConciliacionService = (GeneracionArchivoConciliacionService) applicationContext.getBean("generacionArchivoConciliacionService");
        transaccionDbService = (TransaccionDbService) applicationContext.getBean("transaccionDbService");
    }
    
    public void testGenerar() throws ErrorTAEException{
        System.out.println("Inicio de test de generar archiveishon");
        setup();
        Transaccion transaccion = transaccionDbService.buscarPorId(19);
        generacionArchivoConciliacionService.generarArchivo(transaccion);
        System.out.println("Fin de test de generar archiveishon");
    }
    /*
    public void testGenerarFooter() throws ErrorTAEException{
        System.out.println("Inicio de test de generar archiveishon");
        setup();
        generacionArchivoConciliacionService.generarFooter();
        System.out.println("Fin de test de generar archiveishon");
    }
    */
}
