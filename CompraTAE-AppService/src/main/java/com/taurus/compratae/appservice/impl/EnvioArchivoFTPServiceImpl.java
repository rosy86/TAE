/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.compratae.appservice.EnvioArchivoFTPService;
import com.taurus.compratae.appservice.GeneracionArchivoConciliacionService;
import com.taurus.compratae.appservice.catalogos.ParametroArchivoService;
import com.taurus.compratae.db.dto.Archivo;
import com.taurus.compratae.db.dto.ParametroArchivo;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("envioArchivoFTPService")
@Transactional
public class EnvioArchivoFTPServiceImpl implements EnvioArchivoFTPService {

    @Autowired
    private GeneracionArchivoConciliacionService generacionArchivoConciliacionService;
    @Autowired
    private ParametroArchivoService parametroArchivoService;

    static final String FTP_SERVER = "FTP_SERVER";
    static final String FTP_USER = "FTP_USER";
    static final String FTP_PASSWORD = "FTP_PASSWORD";

    @Override
    public void enviarArchivoFTP() {
        //Primero se debe generar el footer del archivo
        System.out.println("Horaaaaaaaaaaaa y Fechaaaaaaaaaaa: " + new Date());
        Archivo archivo = generacionArchivoConciliacionService.generarFooter();
        //Archivo archivo = archivoService.buscarPorNombre("AMG01032016.txt");///Este es para pruebas
        if (archivo != null) {//Para asegurarnos que en la conexión no haya NullPointer, en caso que no haya archivo.
            conectarFTP(archivo);
        }
    }
    public void conectarFTP(Archivo archivo) {
        FTPClient client = new FTPClient();
        /*String sFTP = "127.0.0.1";
        String sUser = "tae";
        String sPassword = "tae";*/
        String sFTP = buscarParametros(FTP_SERVER);
        String sUser = buscarParametros(FTP_USER);
        String sPassword = buscarParametros(FTP_PASSWORD);
        ///////////////////////////////////
        //String[] lista;
        try {
            client.connect(sFTP);
            boolean login = client.login(sUser, sPassword);
            System.out.println("1. Directorio de trabajo: " + client.printWorkingDirectory());
            client.setFileType(FTP.BINARY_FILE_TYPE);
            BufferedInputStream buffIn = null;
            buffIn = new BufferedInputStream(new FileInputStream(archivo.getNombre()));
            client.enterLocalPassiveMode();
            StringTokenizer tokens = new StringTokenizer(archivo.getNombre(),"/");//Para separar el nombre de la ruta.
            int i=0;
            String nombre = "";
            while (tokens.hasMoreTokens()){
                if(i==1){
                    nombre = tokens.nextToken();
                    i++;
                }else{
                    i++;
                }
            }
            client.storeFile(nombre, buffIn);
            buffIn.close();
            /*lista = client.listNames();
            for (String lista1 : lista) {
                System.out.println(lista1);
            }*/
            //client.changeWorkingDirectory("\\done");
            //System.out.println("2. Working Directory: " + client.printWorkingDirectory());
            client.logout();
            client.disconnect();
            System.out.println("Terminé de conectarme al FTP!!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public String buscarParametros(String nombre) {
        ParametroArchivo parArch = parametroArchivoService.buscarPorNombre(nombre);
        return parArch.getValor();
    }
}