package com.taurus.compratae.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.taurus.compratae.appservice.RecargaService;
import com.taurus.compratae.db.dto.Archivo;
import com.taurus.compratae.db.service.ArchivoDbService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        String[] contexts = {"spring-data-app-context.xml", "appservice-application.context.xml"};
        applicationContext = new ClassPathXmlApplicationContext(contexts);
        archivoDbService = (ArchivoDbService) applicationContext.getBean("archivoDbService");
    }
    public void testBuscarTodo() {
        log.debug("Inicio testRecarga");
        setup();
        Date fecha1 = new Date();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = formatoDelTexto.format(fecha1);
        
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fechaEnviar.getTime());
        cal.add(Calendar.MINUTE, 1439);
        Date fecha2= new java.sql.Date(cal.getTimeInMillis());
        Archivo archivo = archivoDbService.buscarEntreFechas(fechaEnviar, fecha2);
        log.debug("Fin testRecarga");
    }
}
