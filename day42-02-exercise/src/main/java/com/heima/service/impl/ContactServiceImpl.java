package com.heima.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heima.dao.ContactDao;
import com.heima.entity.Contact;
import com.heima.service.ContactService;
import com.heima.utils.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();


        List<Contact> list = null;

        Jedis jedis = JedisUtils.getJedis();
        String json = jedis.get("contacts");
        try {
            if (json == null){
                list = contactDao.findAll();
                String s = objectMapper.writeValueAsString(list);
                jedis.set("contacts",s);
            }else {
                System.out.println("从redis 里面取");
                list  = objectMapper.readValue(json, new TypeReference<List<Contact>>() {
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            jedis.close();
        }

        return list;
    }
}
