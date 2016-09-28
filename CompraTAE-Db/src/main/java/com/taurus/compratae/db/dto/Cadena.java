/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollador java
 */
@Entity
@Table(name = "cadena", catalog = "tae", schema = "public")
public class Cadena implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cadena")
    private Integer idCadena;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCadena", fetch = FetchType.LAZY)
    private Collection<Transaccion> transaccionCollection;

    public Cadena() {
    }

    public Cadena(Integer idCadena) {
        this.idCadena = idCadena;
    }

    public Cadena(Integer idCadena, String codigo) {
        this.idCadena = idCadena;
        this.codigo = codigo;
    }

    public Integer getIdCadena() {
        return idCadena;
    }

    public void setIdCadena(Integer idCadena) {
        this.idCadena = idCadena;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(Collection<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCadena != null ? idCadena.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadena)) {
            return false;
        }
        Cadena other = (Cadena) object;
        if ((this.idCadena == null && other.idCadena != null) || (this.idCadena != null && !this.idCadena.equals(other.idCadena))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentities.dto.Cadena[ idCadena=" + idCadena + " ]";
    }
    
}
