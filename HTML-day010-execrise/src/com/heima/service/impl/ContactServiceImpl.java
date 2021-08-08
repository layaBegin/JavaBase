package com.heima.service.impl;

import com.heima.dao.ContactDao;
import com.heima.dao.Impl.ContactDaoImpl;
import com.heima.entity.Contact;
import com.heima.service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDao contactDao = new ContactDaoImpl();

    @Override
    public List<Contact> findAllContacts() {
        List<Contact> allContacts = contactDao.findAllContacts();
        return allContacts;
    }

    @Override
    public Contact findContactById(Integer id) {
        Contact contact = contactDao.findContactById(id);
        return contact;
    }

    @Override
    public Integer addContact(Contact contact) {
        Integer count = contactDao.addContact(contact);
        return count;
    }

    @Override
    public Integer updateContact(Contact contact) {
        Integer integer = contactDao.updateContact(contact);
        return integer;
    }

    @Override
    public Integer deleteContact(Integer id) {
        Integer count = contactDao.deleteContact(id);
        return count;
    }
}
