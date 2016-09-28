/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.comprataeweb.controller;

import com.taurus.compratae.appservice.ConsultaCreditoService;
import java.io.Serializable;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Desarrollador java
 */
@ManagedBean(name = "consultaCreditoController")
@ViewScoped
public class ConsultaCreditoController implements Serializable {

    private static final long serialVersionUID = 1L;
    transient ConsultaCreditoService consultaCreditoService;
    String resultado;

    public ConsultaCreditoService getConsultaCreditoService() {
        Application app = FacesContext.getCurrentInstance().getApplication();
        consultaCreditoService = app.evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{consultaCreditoService}", ConsultaCreditoService.class);
        return consultaCreditoService;
    }

    public void consultarCredito(){
        resultado = getConsultaCreditoService().consultarCredido();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("consultaCredito.show();");
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
}
