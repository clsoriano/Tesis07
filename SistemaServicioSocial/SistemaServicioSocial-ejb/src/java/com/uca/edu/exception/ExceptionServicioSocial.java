/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author jcsoriano
 */
@ApplicationException(rollback = true)
public class ExceptionServicioSocial extends Exception {

    public ExceptionServicioSocial(String message) {
        super(message);
    }

    public ExceptionServicioSocial(String message, Throwable ex) {
        super(message, ex);
    }
}
