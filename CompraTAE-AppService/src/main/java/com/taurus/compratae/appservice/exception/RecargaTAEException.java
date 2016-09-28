/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.exception;

/**
 *
 * @author Desarrollador java
 */
public class RecargaTAEException extends Exception {
    private static final long serialVersionUID = 1L;

    public RecargaTAEException() {
    }

    public RecargaTAEException(String message) {
        super(message);
    }

    public RecargaTAEException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecargaTAEException(Throwable cause) {
        super(cause);
    }

    public RecargaTAEException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
