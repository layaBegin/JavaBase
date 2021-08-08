package com.heima.dao;

import com.heima.entity.Contact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ContactDao {

    @Select("SELECT * FROM contacts")
    List<Contact> findAllContacts();

    @Select("SELECT * FROM contacts where id=#{id}")
    Contact findContactById(Integer id);

    @Insert("INSERT INTO contacts VALUES (#{id},#{name},#{sex},#{age},#{county},#{qq},#{mail})")
    Integer addContact(Contact contact);

    @Update("UPDATE contacts SET name=#{name},sex=#{sex},age=#{age},county=#{county},qq=#{qq},mail=#{mail} WHERE id = #{id}")
    Integer updateContact(Contact contact);

    @Delete("DELETE FROM contacts WHERE id = #{id}")
    Integer deleteContact(Integer id);

}
