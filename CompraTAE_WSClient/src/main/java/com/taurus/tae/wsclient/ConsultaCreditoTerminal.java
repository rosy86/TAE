
package com.taurus.tae.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para consultaCreditoTerminal complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="consultaCreditoTerminal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_cadena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_tienda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id_terminal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaCreditoTerminal", propOrder = {
    "idCadena",
    "idTienda",
    "idTerminal"
})
public class ConsultaCreditoTerminal {

    @XmlElement(name = "id_cadena")
    protected String idCadena;
    @XmlElement(name = "id_tienda")
    protected String idTienda;
    @XmlElement(name = "id_terminal")
    protected String idTerminal;

    /**
     * Obtiene el valor de la propiedad idCadena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCadena() {
        return idCadena;
    }

    /**
     * Define el valor de la propiedad idCadena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCadena(String value) {
        this.idCadena = value;
    }

    /**
     * Obtiene el valor de la propiedad idTienda.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTienda() {
        return idTienda;
    }

    /**
     * Define el valor de la propiedad idTienda.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTienda(String value) {
        this.idTienda = value;
    }

    /**
     * Obtiene el valor de la propiedad idTerminal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTerminal() {
        return idTerminal;
    }

    /**
     * Define el valor de la propiedad idTerminal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTerminal(String value) {
        this.idTerminal = value;
    }

}
