package com.heima.service;

import com.heima.entity.Contact;
import com.heima.entity.PageBean;

import java.util.List;

public interface ContactService {

    List<Contact> findAllContacts();
    Contact findContactById(Integer id);
    Integer addContact(Contact contact);
    Integer updateContact(Contact contact);
    Integer deleteContact(Integer id);

    PageBean getPageBean(Integer currentPage,Integer pageSize);
}
