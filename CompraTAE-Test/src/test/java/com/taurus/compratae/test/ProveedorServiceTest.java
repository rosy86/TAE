/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.test;

import com.taurus.compratae.appservice.RecargaService;
import com.taurus.compratae.appservice.catalogos.ProveedorService;
import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.model.MontoM;
import com.taurus.compratae.model.ProveedorM;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Desarrollador java
 */
public class ProveedorServiceTest extends TestCase {
    private static final Logger log = LoggerFactory.getLogger(ProveedorServiceTest.class);
    private ProveedorService proveedorService;
    private ApplicationContext applicationContext;
    
    private void setup() {
        String[] contexts = {"spring-data-app-context.xml", "appservice-application.context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        proveedorService = (ProveedorService) applicationContext.getBean("proveedorService");
    }
   /* public void testBuscarTodo() {
        log.debug("Inicio testRecarga");
        setup();
        List<Proveedor> lista = proveedorService.obtenerProveedores();
        log.debug("Fin testRecarga");
    }*/
    public void testBuscarProveedoresMonto(){
        log.debug("Inicio testRecarga");
        setup();
        //Map<ProveedorM, List<MontoM>> mapa = proveedorService.obtenerProveedoresMonto();
        log.debug("Fin testRecarga");
    }
}
