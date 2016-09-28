/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taurus.compratae.appservice.impl;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author Desarrollador java
 */
public class MiAutenticadorAppService extends Authenticator {
 
    static final String user = "agaray"; // Login
    static final String pass = "6I64p9x5u9pdS9W"; // Password
 
    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return (new PasswordAuthentication(user, pass.toCharArray()));
    }
}
