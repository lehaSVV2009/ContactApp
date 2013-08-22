package com.kadet.contactmanager.dao;

import com.kadet.contactmanager.entity.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.08.13
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public abstract class DAOImpl <E extends Entity> implements DAO<E> {

    Class<E> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    protected DAOImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(E entity) {
        getSession().saveOrUpdate(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll() {
        return getSession().createQuery("from " + entityClass.getName())
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean delete(int id) {
        E ent = (E) getSession().load(entityClass, id);
        if (ent != null) {
            getSession().delete(ent);
            return true;
        }
        return false;
    }

    @Override
    public E findByID(int id) {
        return (E) getSession().get(entityClass, id);
    }
}
