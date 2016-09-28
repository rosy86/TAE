/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice;

import com.taurus.compratae.db.dto.Cadena;
import com.taurus.compratae.db.dto.Folio;
import com.taurus.compratae.db.dto.Monto;
import com.taurus.compratae.db.dto.Proveedor;
import com.taurus.compratae.db.dto.Terminal;
import com.taurus.compratae.db.dto.Tienda;
import com.taurus.compratae.db.dto.Transaccion;
import java.util.Date;

/**
 *
 * @author Desarrollador java
 */
public interface TransaccionService {
    public Transaccion guardar(Cadena cadena, Tienda tienda, Terminal terminal, Folio folio, Date fecha, Proveedor proveedor, Monto monto,
            String telefono, int intento);
    public Transaccion guardarTransaccion(Transaccion transaccion);
}
