/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.dto;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Desarrollador java
 */
@Entity
@Table(name = "parametro_archivo", catalog = "tae", schema = "public")
public class ParametroArchivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_parametro")
    private Integer idParametro;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "rellenarconceros")
    private boolean rellenarconceros;
    @Column(name = "decimales")
    private Integer decimales;
    @Column(name = "rellenarconespacios")
    private boolean rellenarconespacios;
    @Column(name = "longitudtotal")
    private Integer longitudtotal;

    public ParametroArchivo() {
    }

    public ParametroArchivo(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public ParametroArchivo(Integer idParametro, String nombre, boolean rellenarconceros) {
        this.idParametro = idParametro;
        this.nombre = nombre;
        this.rellenarconceros = rellenarconceros;
    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isRellenarconceros() {
        return rellenarconceros;
    }

    public void setRellenarconceros(boolean rellenarconceros) {
        this.rellenarconceros = rellenarconceros;
    }

    public Integer getDecimales() {
        return decimales;
    }

    public void setDecimales(Integer decimales) {
        this.decimales = decimales;
    }

    public boolean isRellenarconespacios() {
        return rellenarconespacios;
    }

    public void setRellenarconespacios(boolean rellenarconespacios) {
        this.rellenarconespacios = rellenarconespacios;
    }

    public Integer getLongitudtotal() {
        return longitudtotal;
    }

    public void setLongitudtotal(Integer longitudtotal) {
        this.longitudtotal = longitudtotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParametro != null ? idParametro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroArchivo)) {
            return false;
        }
        ParametroArchivo other = (ParametroArchivo) object;
        if ((this.idParametro == null && other.idParametro != null) || (this.idParametro != null && !this.idParametro.equals(other.idParametro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentities.dto.ParametroArchivo[ idParametro=" + idParametro + " ]";
    }
    
}
