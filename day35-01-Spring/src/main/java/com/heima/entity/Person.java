package com.heima.entity;

import java.util.*;

public class Person {

    //字符串数组
    private String[] array;
    //字符串类型的List集合
    private List<String> list;
    //字符串类型的Set集合
    private Set<String> set;
    //字符串的键和值Map集合
    private Map<String, String> map;
    //Properties属性集合
    private Properties prop;

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    @Override
    public String toString() {
        return "Person{" +
                "array=" + Arrays.toString(array) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", prop=" + prop +
                '}';
    }
}