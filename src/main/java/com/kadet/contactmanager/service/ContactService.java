package com.kadet.contactmanager.service;

import com.kadet.contactmanager.dao.ContactDAO;
import com.kadet.contactmanager.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 21.08.13
 * Time: 1:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ContactService implements EntityService<Contact>{

    @Autowired
    private ContactDAO contactDAO;

    public void saveOrUpdate (Contact entity) {
        contactDAO.saveOrUpdate(entity);
    }

    public List<Contact> findAll () {
        return contactDAO.findAll();
    }

    public boolean delete (int id) {
        return contactDAO.delete(id);
    }

    public Contact findByID (int id) {
        return contactDAO.findByID(id);
    }
}
