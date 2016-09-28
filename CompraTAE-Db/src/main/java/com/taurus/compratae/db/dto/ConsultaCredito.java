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
@Table(name = "consulta_credito", catalog = "tae", schema = "public")
public class ConsultaCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @Basic(optional = false)
    @Column(name = "fechasaldo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasaldo;
    @Basic(optional = false)
    @Column(name = "credito")
    private String credito;
    @JoinColumn(name = "id_respuesta", referencedColumnName = "id_respuesta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Respuesta idRespuesta;

    public ConsultaCredito() {
    }

    public ConsultaCredito(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public ConsultaCredito(Integer idConsulta, Date fechasaldo, String credito) {
        this.idConsulta = idConsulta;
        this.fechasaldo = fechasaldo;
        this.credito = credito;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Date getFechasaldo() {
        return fechasaldo;
    }

    public void setFechasaldo(Date fechasaldo) {
        this.fechasaldo = fechasaldo;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public Respuesta getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Respuesta idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaCredito)) {
            return false;
        }
        ConsultaCredito other = (ConsultaCredito) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpaentities.dto.ConsultaCredito[ idConsulta=" + idConsulta + " ]";
    }
    
}
