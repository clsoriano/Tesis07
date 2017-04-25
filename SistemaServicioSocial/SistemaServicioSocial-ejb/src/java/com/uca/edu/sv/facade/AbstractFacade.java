/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import java.io.Serializable;

/**
 *
 * @author jcsoriano
 */
public abstract class AbstractFacade<T> extends AbstractTemplate<T> implements Serializable {

    private final Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
}
