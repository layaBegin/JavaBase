package com.heima.controller;

import com.heima.entity.Contact;
import com.heima.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @RequestMapping("/find")
    @ResponseBody
    public List<Contact> findAll(){
        List<Contact> list = contactService.findAll();
        return list;
    }
}
