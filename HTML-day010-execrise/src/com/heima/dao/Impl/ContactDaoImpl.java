package com.heima.dao.Impl;

import com.heima.dao.ContactDao;
import com.heima.entity.Contact;
import com.heima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ContactDaoImpl implements ContactDao {
    @Override
    public List<Contact> findAllContacts() {
        SqlSession session = MyBatisUtils.getSession();
        ContactDao mapper = session.getMapper(ContactDao.class);
        List<Contact> allContacts = mapper.findAllContacts();
        return allContacts;
    }

    @Override
    public Contact findContactById(Integer id) {
        SqlSession session = MyBatisUtils.getSession();
        ContactDao mapper = session.getMapper(ContactDao.class);
        Contact contact = mapper.findContactById(id);
        return contact;
    }

    @Override
    public Integer addContact(Contact contact) {
        SqlSession session = MyBatisUtils.getSession();
        ContactDao mapper = session.getMapper(ContactDao.class);

        Integer count = mapper.addContact(contact);
        if (count > 0){
            session.commit();
            session.close();
            return count;
        }else {
            session.rollback();
            return 0;
        }
    }

    @Override
    public Integer updateContact(Contact contact) {
        SqlSession session = MyBatisUtils.getSession();
        ContactDao mapper = session.getMapper(ContactDao.class);
        Integer count = mapper.updateContact(contact);
        if (count > 0){
            session.commit();
            session.close();
            return count;
        }else {
            session.rollback();
            return 0;
        }
    }

    @Override
    public Integer deleteContact(Integer id) {
        SqlSession session = MyBatisUtils.getSession();
        ContactDao mapper = session.getMapper(ContactDao.class);
        Integer count = mapper.deleteContact(id);
        if (count > 0){
            session.commit();
            session.close();
            return count;
        }else {
            session.rollback();
            return 0;
        }
    }
}
