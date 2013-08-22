package com.kadet.contactmanager.service;

import com.kadet.contactmanager.entity.Contact;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 21.08.13
 * Time: 1:53
 * To change this template use File | Settings | File Templates.
 */
public interface EntityService <E>{

    public void saveOrUpdate (E entity);

    public List<E> findAll ();

    public boolean delete (int id);

    public E findByID (int id);

}
