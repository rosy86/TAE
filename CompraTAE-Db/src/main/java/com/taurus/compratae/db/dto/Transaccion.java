/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Desarrollador java
 */
@Entity
@Table(name = "transaccion", catalog = "tae", schema = "public")

public class Transaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_transaccion")
    private Integer idTransaccion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "autorizacion")
    private String autorizacion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "leyendaticket1")
    private String leyendaticket1;
    @Column(name = "leyendaticket2")
    private String leyendaticket2;
    @Column(name = "vigencia")
    private Integer vigencia;
    @Column(name = "intento")
    private Integer intento;
    @JoinColumn(name = "id_archivo", referencedColumnName = "id_archivo")
    @ManyToOne(fetch = FetchType.LAZY)
    private Archivo idArchivo;
    @JoinColumn(name = "id_cadena", referencedColumnName = "id_cadena")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cadena idCadena;
    @JoinColumn(name = "id_folio", referencedColumnName = "id_folio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Folio idFolio;
    @JoinColumn(name = "id_monto", referencedColumnName = "id_monto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Monto idMonto;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor idProveedor;
    @JoinColumn(name = "id_respuesta", referencedColumnName = "id_respuesta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Respuesta idRespuesta;
    @JoinColumn(name = "id_terminal", referencedColumnName = "id_terminal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Terminal idTerminal;
    @JoinColumn(name = "id_tienda", referencedColumnName = "id_tienda")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda idTienda;

    public Transaccion() {
    }

    public Transaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transaccion(Integer idTransaccion, String telefono, Date fecha) {
        this.idTransaccion = idTransaccion;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLeyendaticket1() {
        return leyendaticket1;
    }

    public void setLeyendaticket1(String leyendaticket1) {
        this.leyendaticket1 = leyendaticket1;
    }

    public String getLeyendaticket2() {
        return leyendaticket2;
    }

    public void setLeyendaticket2(String leyendaticket2) {
        this.leyendaticket2 = leyendaticket2;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public Integer getIntento() {
        return intento;
    }

    public void setIntento(Integer intento) {
        this.intento = intento;
    }

    public Archivo getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(Archivo idArchivo) {
        this.idArchivo = idArchivo;
    }

    public Cadena getIdCadena() {
        return idCadena;
    }

    public void setIdCadena(Cadena idCadena) {
        this.idCadena = idCadena;
    }

    public Folio getIdFolio() {
        return idFolio;
    }

    public void setIdFolio(Folio idFolio) {
        this.idFolio = idFolio;
    }

    public Monto getIdMonto() {
        return idMonto;
    }

    public void setIdMonto(Monto idMonto) {
        this.idMonto = idMonto;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Respuesta getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Respuesta idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Terminal getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Terminal idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Tienda getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(Tienda idTienda) {
        this.idTienda = idTienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransaccion != null ? idTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaccion)) {
            return false;
        }
        Transaccion other = (Transaccion) object;
        if ((this.idTransaccion == null && other.idTransaccion != null) || (this.idTransaccion != null && !this.idTransaccion.equals(other.idTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentities.dto.Transaccion[ idTransaccion=" + idTransaccion + " ]";
    }
    
}
