/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.db.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Desarrollador java
 */
@Entity
@Table(name = "monto", catalog = "tae", schema = "public")

public class Monto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_monto")
    private Integer idMonto;
    @Basic(optional = false)
    @Column(name = "monto")
    private int monto;
    @JoinTable(name = "monto_proveddor", joinColumns = {
        @JoinColumn(name = "id_monto", referencedColumnName = "id_monto")}, inverseJoinColumns = {
        @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Proveedor> proveedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMonto", fetch = FetchType.LAZY)
    private List<Transaccion> transaccionCollection;

    public Monto() {
    }

    public Monto(Integer idMonto) {
        this.idMonto = idMonto;
    }

    public Monto(Integer idMonto, int monto) {
        this.idMonto = idMonto;
        this.monto = monto;
    }

    public Integer getIdMonto() {
        return idMonto;
    }

    public void setIdMonto(Integer idMonto) {
        this.idMonto = idMonto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @XmlTransient
    public List<Proveedor> getProveedorCollection() {
        return proveedorCollection;
    }

    public void setProveedorCollection(List<Proveedor> proveedorCollection) {
        this.proveedorCollection = proveedorCollection;
    }

    @XmlTransient
    public List<Transaccion> getTransaccionCollection() {
        return transaccionCollection;
    }

    public void setTransaccionCollection(List<Transaccion> transaccionCollection) {
        this.transaccionCollection = transaccionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMonto != null ? idMonto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monto)) {
            return false;
        }
        Monto other = (Monto) object;
        if ((this.idMonto == null && other.idMonto != null) || (this.idMonto != null && !this.idMonto.equals(other.idMonto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentities.dto.Monto[ idMonto=" + idMonto + " ]";
    }
    
}
