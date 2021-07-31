package com.heima.entity;
import java.sql.Date;
/**
 * 书籍实体类
 */
public class Book {

    private int id;
    private String name;
    private String author;
    private Date time;  //注：使用java.sql.Date类型， 以前学的java.util.Date
    private int type;

    public Book() {
    }

    public Book(int id, String name, String author, Date time, int type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.time = time;
        this.type = type;
    }

    //getter和setter省略
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + ", time=" + time
                + ", type=" + type + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}