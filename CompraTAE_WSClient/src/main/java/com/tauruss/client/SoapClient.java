package com.tauruss.client;

import com.taurus.tae.wsclient.RespuestaRecarga;
import java.net.Authenticator;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoapClient.class);
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEEE, MMMM d yyyy");

    public static void main(String[] args) {
        try {
            LOGGER.debug("Creating weather service instance (Note: Weather = Service subclass)...");
            long start = new Date().getTime();

            String idCadena = "39";
            String idTienda = "5";
            String idTerminal = "01";
            String folio = "12345";
            String fecha = "20110101 13:05:05";
            String telefono = "5512971063";
            String monto = "100";
            String proveedor = "01";
            RespuestaRecarga respRec = recargaSaldo(idCadena, idTienda, idTerminal, folio, fecha, telefono, monto, proveedor);
            System.out.println("Folio: " + respRec.getFolio());

        } catch (Exception e) {
            LOGGER.error("An exception occurred, exiting", e);
        }
    }

    private static RespuestaRecarga recargaSaldo(java.lang.String idCadena, java.lang.String idTienda, java.lang.String idTerminal, java.lang.String folio, java.lang.String fecha, java.lang.String telefono, java.lang.String monto, java.lang.String proveedor) {

        Authenticator.setDefault(new MiAutenticador());
        com.taurus.tae.wsclient.WsTae_Service service = new com.taurus.tae.wsclient.WsTae_Service();
        com.taurus.tae.wsclient.WsTae port = service.getWsTaePort();
        return port.recargaSaldo(idCadena, idTienda, idTerminal, folio, fecha, telefono, monto, proveedor);
    }
}
