/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Desarrollador java
 */
public class EscrituraArchivoPrueba {

    public static void main(String[] args) throws Exception {

        EscrituraArchivoPrueba ar = new EscrituraArchivoPrueba();
        ar.escribirArchivo(ar.crearArchivo(), "Mi cadena");
        //Es importante usar doble diagonal para que la ruta sea
        //correcta
    }

    public PrintWriter crearArchivo() throws IOException  {
        FileWriter writer = null;

        File dir = new File("archivo/");
        if(!dir.exists()){
            dir.mkdir();
        }
            //Las siguientes 3 líneas nos permite crear un archivo y escribir en el
            File archivo = new File("archivo/ArchivoDePrueba.txt");
            writer = new FileWriter(archivo);
            PrintWriter salida = new PrintWriter(writer);
            return salida;
        
    }

    public PrintWriter escribirArchivo(PrintWriter salida, String cadena) throws Exception {
        //Este método permite escribir en el archivo
        salida.append("Mi Archivo Plano");
        //Este método sirve para dar un salto de línea
        salida.println();
        //Tambien el método write nos permite escribir
        salida.write(cadena);
        //Al Igual que print
        salida.print(cadena);
        //Es importante no olvidar cerrar el archivo
        salida.close();
        return salida;
    }

}
