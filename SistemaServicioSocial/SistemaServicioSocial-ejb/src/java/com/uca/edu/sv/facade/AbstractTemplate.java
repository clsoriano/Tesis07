/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uca.edu.sv.facade;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jcsoriano
 */
public class AbstractTemplate<T> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T createQueryNombra(String nombreQuery, HashMap<?, Object> parametros, Class<?> clase) {
        TypedQuery query = getEntityManager().createNamedQuery(nombreQuery, clase);
        return (T) setParametros(query, parametros).getSingleResult();

    }

    public List<T> createQueryNombra(String nombreQuery, Class<?> clase) {
        TypedQuery query = getEntityManager().createNamedQuery(nombreQuery, clase);
        return (List<T>) query.getResultList();
    }

    public List<T> createQueryListNombra(String nombreQuery, HashMap<?, Object> parametros, Class<?> clase) {
        TypedQuery query = getEntityManager().createNamedQuery(nombreQuery, clase);
        return (List<T>) setParametros(query, parametros).getResultList();

    }

    public TypedQuery setParametros(TypedQuery query, HashMap<?, Object> parametros) {
        for (Map.Entry entry : parametros.entrySet()) {
            if (entry.getKey() instanceof String) {
                query.setParameter((String) entry.getKey(), entry.getValue());
            }
        }
        return query;
    }
}
