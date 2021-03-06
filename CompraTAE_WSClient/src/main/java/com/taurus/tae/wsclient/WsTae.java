
package com.taurus.tae.wsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "wsTae", targetNamespace = "http://tae.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsTae {


    /**
     * 
     * @param idCadena
     * @param idTerminal
     * @param idTienda
     * @return
     *     returns com.taurus.tae.wsclient.RespuestaCredito
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaCreditoTerminal", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.ConsultaCreditoTerminal")
    @ResponseWrapper(localName = "consultaCreditoTerminalResponse", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.ConsultaCreditoTerminalResponse")
    @Action(input = "http://tae.com/wsTae/consultaCreditoTerminalRequest", output = "http://tae.com/wsTae/consultaCreditoTerminalResponse")
    public RespuestaCredito consultaCreditoTerminal(
        @WebParam(name = "id_cadena", targetNamespace = "")
        String idCadena,
        @WebParam(name = "id_tienda", targetNamespace = "")
        String idTienda,
        @WebParam(name = "id_terminal", targetNamespace = "")
        String idTerminal);

    /**
     * 
     * @return
     *     returns com.taurus.tae.wsclient.RespuestaCredito
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaCredito", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.ConsultaCredito")
    @ResponseWrapper(localName = "consultaCreditoResponse", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.ConsultaCreditoResponse")
    @Action(input = "http://tae.com/wsTae/consultaCreditoRequest", output = "http://tae.com/wsTae/consultaCreditoResponse")
    public RespuestaCredito consultaCredito();

    /**
     * 
     * @param fecha
     * @param monto
     * @param idCadena
     * @param folio
     * @param idTerminal
     * @param telefono
     * @param idTienda
     * @return
     *     returns com.taurus.tae.wsclient.RespuestaRecarga
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "consultaRecarga", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.ConsultaRecarga")
    @ResponseWrapper(localName = "consultaRecargaResponse", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.ConsultaRecargaResponse")
    @Action(input = "http://tae.com/wsTae/consultaRecargaRequest", output = "http://tae.com/wsTae/consultaRecargaResponse")
    public RespuestaRecarga consultaRecarga(
        @WebParam(name = "id_cadena", targetNamespace = "")
        String idCadena,
        @WebParam(name = "id_tienda", targetNamespace = "")
        String idTienda,
        @WebParam(name = "id_terminal", targetNamespace = "")
        String idTerminal,
        @WebParam(name = "folio", targetNamespace = "")
        String folio,
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha,
        @WebParam(name = "telefono", targetNamespace = "")
        String telefono,
        @WebParam(name = "monto", targetNamespace = "")
        String monto);

    /**
     * 
     * @param fecha
     * @param monto
     * @param idCadena
     * @param folio
     * @param proveedor
     * @param idTerminal
     * @param telefono
     * @param idTienda
     * @return
     *     returns com.taurus.tae.wsclient.RespuestaRecarga
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "recargaSaldo", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.RecargaSaldo")
    @ResponseWrapper(localName = "recargaSaldoResponse", targetNamespace = "http://tae.com/", className = "com.taurus.tae.wsclient.RecargaSaldoResponse")
    @Action(input = "http://tae.com/wsTae/recargaSaldoRequest", output = "http://tae.com/wsTae/recargaSaldoResponse")
    public RespuestaRecarga recargaSaldo(
        @WebParam(name = "id_cadena", targetNamespace = "")
        String idCadena,
        @WebParam(name = "id_tienda", targetNamespace = "")
        String idTienda,
        @WebParam(name = "id_terminal", targetNamespace = "")
        String idTerminal,
        @WebParam(name = "folio", targetNamespace = "")
        String folio,
        @WebParam(name = "fecha", targetNamespace = "")
        String fecha,
        @WebParam(name = "telefono", targetNamespace = "")
        String telefono,
        @WebParam(name = "monto", targetNamespace = "")
        String monto,
        @WebParam(name = "proveedor", targetNamespace = "")
        String proveedor);

}
