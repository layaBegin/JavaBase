package com.heima.haxiSet_hashMap;

import java.util.*;
import java.util.function.BiConsumer;

/**Map 的底层 和Set集合一样，key 完全一样， 只是多了一个value
 * HashMap:元素按照键是无序，不重复，无索引，值不做要求。（与Map体系一致）
 * LinkedHashMap:元素按照键是有序，不重复，无索引，值不做要求。
 * TreeMap：元素按照建是排序，不重复，无索引的，值不做要求。
 */

/**
 * 由键决定：无序、不重复、无索引。HashMap底层是哈希表结构的。
 * 依赖hashCode方法和equals方法保证键的唯一。
 * 如果键要存储的是自定义对象，如果要去重 需要重写hashCode和equals方法。
 * 基于哈希表。增删改查的性能都较好。
 */
public class Demo_HashMap {
    public static void main(String[] args) {
       /* Map<String,String> map = new HashMap<>();
        Map<String,String> linkedmap = new LinkedHashMap<>();
        map.put("1","zhangsan");
        map.put("2","lishi");
        map.put("娃娃","汪汪");*/
      /*  System.out.println(map);
        System.out.println(map.get("娃娃"));
        System.out.println(map.isEmpty());
        System.out.println("size:"+map.size());
        //map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("lishi"));
        System.out.println(map.entrySet());*/

        /*//将map 的键转为Set 集合
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s);
        }

        //将map 的value转为Collection 集合
        Collection<String> collection = map.values();
        for (String c : collection) {
            System.out.println(c);
        }

        Map<String,String> map2 = new HashMap<>();
        map2.put("erre","ee");
        map2.put("赵敏","贾静雯");
        //拷贝导入
        map.putAll(map2);
        System.out.println(map);
        System.out.println(map2);
        */

        /*//将map 转为Map.Entry<K, V> map 的实体类
        Set<Map.Entry<String, String>> entries = map.entrySet();
        System.out.println(entries);
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());

        }*/

       /* //Lambda 表达式遍历
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + ":" + s2);
            }
        });
        map.forEach((String s, String s2)-> System.out.println(s + ":" + s2)
        );*/


        Map<Orange,Integer> map = new HashMap<>();
        map.put(new Orange("1hao","黄色",1.2),2);
        map.put(new Orange("1hao","橙色",1.2),67);
        map.put(new Orange("3hao","绿色",2.3),89);
        map.put(new Orange("4hao","红色",1.5),76);
        System.out.println(map);


    }
}

class Orange{
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    private String name;

    public Orange(String name, String color, double price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String color;
    private double price;

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}

