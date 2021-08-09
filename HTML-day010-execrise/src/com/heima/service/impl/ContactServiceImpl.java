package com.heima.service.impl;

import com.heima.dao.ContactDao;
import com.heima.dao.Impl.ContactDaoImpl;
import com.heima.entity.Contact;
import com.heima.entity.PageBean;
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

    @Override
    public PageBean getPageBean(Integer currentPage,Integer pageSize) {

        Integer count = contactDao.getCount();
        Integer totalPage;
        if (count % pageSize == 0){
            totalPage = count / pageSize;
        }else {
            totalPage = count / pageSize + 1;
        }

        Integer begin = (currentPage - 1) * pageSize;
        List<Contact> data = contactDao.getOnePageContact(begin,pageSize);
        Integer previousPage = (currentPage - 1) < 1 ? 1 : (currentPage - 1);
        Integer nextPage = (currentPage + 1) > totalPage ? totalPage : (currentPage + 1);

        PageBean pageBean = new PageBean(data,previousPage,nextPage,pageSize,currentPage,totalPage,count);
        return pageBean;
    }
}
