/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.comprataeweb.controller;

import com.taurus.compratae.appservice.catalogos.MontoService;
import com.taurus.compratae.appservice.catalogos.ProveedorService;
import com.taurus.compratae.appservice.RecargaService;
import com.taurus.compratae.appservice.exception.ErrorTAEException;
import com.taurus.compratae.appservice.exception.ValidacionException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Desarrollador java
 */
@ManagedBean(name = "recargaController")
@ViewScoped
public class RecargaController implements Serializable {

    private static final long serialVersionUID = 1L;

    public String telefono1;
    public String telefono2;
    public String monto;
    public String proveedor;
    public List<String> listaProvs;
    public List<String> listaMontos;
    transient ProveedorService proveedorService;
    transient MontoService montoService;
    transient RecargaService recargaService;
    String error;
    String warning;
    String exito;

    public RecargaController() {
        listaProvs = new ArrayList<String>();
        listaMontos = new ArrayList<String>();
    }

    public ProveedorService getProveedorService() {
        Application app = FacesContext.getCurrentInstance().getApplication();
        proveedorService = app.evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{proveedorService}", ProveedorService.class);
        return proveedorService;
    }

    public MontoService getMontoService() {
        Application app = FacesContext.getCurrentInstance().getApplication();
        montoService = app.evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{montoService}", MontoService.class);
        return montoService;
    }

    public RecargaService getRecargaService() {
        Application app = FacesContext.getCurrentInstance().getApplication();
        recargaService = app.evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{recargaService}", RecargaService.class);
        return recargaService;
    }

    @PostConstruct
    public void consultaInicial() {
        listaProvs = getProveedorService().obtenerProveedoresString();
    }

    public void consultaMontosProveedor() {
        listaMontos = getProveedorService().obtnenerProveedoresMonto(proveedor);
    }

    public void realizarRecargaTAE() {
        try {
            System.out.println("Entre a realizar la recarga");
            String resultado = getRecargaService().realizarRecargarTAE(proveedor, monto, telefono1, telefono2);
            RequestContext context = RequestContext.getCurrentInstance();
            exito = resultado;
            context.execute("exitoTae.show();");
        } catch (ValidacionException ex) {
            RequestContext context = RequestContext.getCurrentInstance();
            warning = ex.getMessage();
            context.execute("advertenciaTae.show();");
            Logger.getLogger(RecargaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErrorTAEException ex) {
            RequestContext context = RequestContext.getCurrentInstance();
            error = ex.getMessage();
            context.execute("errorTae.show();");
            Logger.getLogger(RecargaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getListaProvs() {
        return listaProvs;
    }
    public void setListaProvs(List<String> listaProvs) {
        this.listaProvs = listaProvs;
    }
    public List<String> getListaMontos() {
        return listaMontos;
    }

    public void setListaMontos(List<String> listaMontos) {
        this.listaMontos = listaMontos;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getExito() {
        return exito;
    }

    public void setExito(String exito) {
        this.exito = exito;
    }    
}
