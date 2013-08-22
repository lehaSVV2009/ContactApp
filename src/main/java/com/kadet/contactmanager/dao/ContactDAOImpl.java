package com.kadet.contactmanager.dao;

import com.kadet.contactmanager.entity.Contact;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.08.13
 * Time: 22:27
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ContactDAOImpl extends DAOImpl<Contact> implements ContactDAO{

    public ContactDAOImpl () {
        super(Contact.class);
    }

}
