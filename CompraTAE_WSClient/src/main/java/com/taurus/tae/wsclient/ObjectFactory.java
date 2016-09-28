
package com.taurus.tae.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.taurus.tae.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultaCredito_QNAME = new QName("http://tae.com/", "consultaCredito");
    private final static QName _ConsultaCreditoTerminalResponse_QNAME = new QName("http://tae.com/", "consultaCreditoTerminalResponse");
    private final static QName _ConsultaRecarga_QNAME = new QName("http://tae.com/", "consultaRecarga");
    private final static QName _ConsultaCreditoResponse_QNAME = new QName("http://tae.com/", "consultaCreditoResponse");
    private final static QName _ConsultaCreditoTerminal_QNAME = new QName("http://tae.com/", "consultaCreditoTerminal");
    private final static QName _RecargaSaldoResponse_QNAME = new QName("http://tae.com/", "recargaSaldoResponse");
    private final static QName _RecargaSaldo_QNAME = new QName("http://tae.com/", "recargaSaldo");
    private final static QName _ConsultaRecargaResponse_QNAME = new QName("http://tae.com/", "consultaRecargaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.taurus.tae.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultaRecargaResponse }
     * 
     */
    public ConsultaRecargaResponse createConsultaRecargaResponse() {
        return new ConsultaRecargaResponse();
    }

    /**
     * Create an instance of {@link RecargaSaldoResponse }
     * 
     */
    public RecargaSaldoResponse createRecargaSaldoResponse() {
        return new RecargaSaldoResponse();
    }

    /**
     * Create an instance of {@link ConsultaCreditoResponse }
     * 
     */
    public ConsultaCreditoResponse createConsultaCreditoResponse() {
        return new ConsultaCreditoResponse();
    }

    /**
     * Create an instance of {@link ConsultaCreditoTerminal }
     * 
     */
    public ConsultaCreditoTerminal createConsultaCreditoTerminal() {
        return new ConsultaCreditoTerminal();
    }

    /**
     * Create an instance of {@link RecargaSaldo }
     * 
     */
    public RecargaSaldo createRecargaSaldo() {
        return new RecargaSaldo();
    }

    /**
     * Create an instance of {@link ConsultaRecarga }
     * 
     */
    public ConsultaRecarga createConsultaRecarga() {
        return new ConsultaRecarga();
    }

    /**
     * Create an instance of {@link ConsultaCredito }
     * 
     */
    public ConsultaCredito createConsultaCredito() {
        return new ConsultaCredito();
    }

    /**
     * Create an instance of {@link ConsultaCreditoTerminalResponse }
     * 
     */
    public ConsultaCreditoTerminalResponse createConsultaCreditoTerminalResponse() {
        return new ConsultaCreditoTerminalResponse();
    }

    /**
     * Create an instance of {@link RespuestaCredito }
     * 
     */
    public RespuestaCredito createRespuestaCredito() {
        return new RespuestaCredito();
    }

    /**
     * Create an instance of {@link RespuestaRecarga }
     * 
     */
    public RespuestaRecarga createRespuestaRecarga() {
        return new RespuestaRecarga();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "consultaCredito")
    public JAXBElement<ConsultaCredito> createConsultaCredito(ConsultaCredito value) {
        return new JAXBElement<ConsultaCredito>(_ConsultaCredito_QNAME, ConsultaCredito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCreditoTerminalResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "consultaCreditoTerminalResponse")
    public JAXBElement<ConsultaCreditoTerminalResponse> createConsultaCreditoTerminalResponse(ConsultaCreditoTerminalResponse value) {
        return new JAXBElement<ConsultaCreditoTerminalResponse>(_ConsultaCreditoTerminalResponse_QNAME, ConsultaCreditoTerminalResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaRecarga }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "consultaRecarga")
    public JAXBElement<ConsultaRecarga> createConsultaRecarga(ConsultaRecarga value) {
        return new JAXBElement<ConsultaRecarga>(_ConsultaRecarga_QNAME, ConsultaRecarga.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCreditoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "consultaCreditoResponse")
    public JAXBElement<ConsultaCreditoResponse> createConsultaCreditoResponse(ConsultaCreditoResponse value) {
        return new JAXBElement<ConsultaCreditoResponse>(_ConsultaCreditoResponse_QNAME, ConsultaCreditoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaCreditoTerminal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "consultaCreditoTerminal")
    public JAXBElement<ConsultaCreditoTerminal> createConsultaCreditoTerminal(ConsultaCreditoTerminal value) {
        return new JAXBElement<ConsultaCreditoTerminal>(_ConsultaCreditoTerminal_QNAME, ConsultaCreditoTerminal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecargaSaldoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "recargaSaldoResponse")
    public JAXBElement<RecargaSaldoResponse> createRecargaSaldoResponse(RecargaSaldoResponse value) {
        return new JAXBElement<RecargaSaldoResponse>(_RecargaSaldoResponse_QNAME, RecargaSaldoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecargaSaldo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "recargaSaldo")
    public JAXBElement<RecargaSaldo> createRecargaSaldo(RecargaSaldo value) {
        return new JAXBElement<RecargaSaldo>(_RecargaSaldo_QNAME, RecargaSaldo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaRecargaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tae.com/", name = "consultaRecargaResponse")
    public JAXBElement<ConsultaRecargaResponse> createConsultaRecargaResponse(ConsultaRecargaResponse value) {
        return new JAXBElement<ConsultaRecargaResponse>(_ConsultaRecargaResponse_QNAME, ConsultaRecargaResponse.class, null, value);
    }

}
