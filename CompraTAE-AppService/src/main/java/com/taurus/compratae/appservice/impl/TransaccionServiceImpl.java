/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;

import com.taurus.compratae.appservice.TransaccionService;
import com.taurus.compratae.db.dto.Cadena;
import com.taurus.compratae.db.dto.Folio;
import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.dto.Terminal;
import com.taurus.compratae.db.dto.Tienda;
import com.taurus.compratae.db.dto.Transaccion;
import com.taurus.compratae.db.service.TransaccionDbService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Desarrollador java
 */
@Service("transaccionService")
@Transactional
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    TransaccionDbService transaccionDbService;
    
    @Override
    public Transaccion guardar(Cadena cadena, Tienda tienda, Terminal terminal, Folio folio, Date fecha, Proveedor proveedor, Monto monto,
            String telefono, int intento) {
        Transaccion transaccion = new Transaccion();
        transaccion.setFecha(fecha);
        transaccion.setIdCadena(cadena);
        transaccion.setIdFolio(folio);
        transaccion.setIdMonto(monto);
        transaccion.setIdProveedor(proveedor);
        transaccion.setIdTerminal(terminal);
        transaccion.setIdTienda(tienda);
        transaccion.setTelefono(telefono);   
        transaccion.setIntento(intento);
        
        return transaccionDbService.guardar(transaccion);
        
    }

    public Transaccion guardarTransaccion(Transaccion transaccion) {
        return transaccionDbService.guardar(transaccion);
    }
    
}
