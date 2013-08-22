package com.kadet.contactmanager.controller;

import com.kadet.contactmanager.dao.ContactDAO;
import com.kadet.contactmanager.entity.Contact;
import com.kadet.contactmanager.service.ContactService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.08.13
 * Time: 22:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    @Transactional
    public String findAllContacts(ModelMap uiModelMap) {

        try {
            List<Contact> contacts = contactService.findAll();
            uiModelMap.addAttribute("contacts", contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "main_page";
        //return "main_page";
    }

    @RequestMapping(value = "/create_contact", method = RequestMethod.GET)
    @Transactional
    public String createContact(ModelMap uiModelMap, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("description") String description) {

        try {
            Contact contact = new Contact();
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setDescription(description);
            contactService.saveOrUpdate(contact);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
