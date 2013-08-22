package com.kadet.contactmanager.dao;

import com.kadet.contactmanager.entity.Entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.08.13
 * Time: 22:24
 * To change this template use File | Settings | File Templates.
 */
public interface DAO<E extends Entity> {

    public void saveOrUpdate (E entity);

    public List<E> findAll ();

    public boolean delete (int id);

    public E findByID (int id);

}

