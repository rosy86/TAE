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
@Table(name = "folio", catalog = "tae", schema = "public")

public class Folio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_folio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFolio;
    @Basic(optional = false)
    @Column(name = "folio")
    private String folio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFolio", fetch = FetchType.LAZY)
    private Collection<Transaccion> transaccionCollection;

    public Folio() {
    }

    public Folio(Integer idFolio) {
        this.idFolio = idFolio;
    }

    public Folio(Integer idFolio, String folio) {
        this.idFolio = idFolio;
        this.folio = folio;
    }

    public Integer getIdFolio() {
        return idFolio;
    }

    public void setIdFolio(Integer idFolio) {
        this.idFolio = idFolio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
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
        hash += (idFolio != null ? idFolio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Folio)) {
            return false;
        }
        Folio other = (Folio) object;
        if ((this.idFolio == null && other.idFolio != null) || (this.idFolio != null && !this.idFolio.equals(other.idFolio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentities.dto.Folio[ idFolio=" + idFolio + " ]";
    }
    
}
