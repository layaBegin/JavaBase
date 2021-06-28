package com.heima.Collection_List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo_delete_foreach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("赵敏");
        list.add("周芷若");
        list.add("小昭");
        list.add("周芷若");
        list.add("周芷若");

        //会报错
        /*Iterator<String> i = list.iterator();
        while (i.hasNext()){
            String s = i.next();
            if (s.equals("周芷若")){
                list.remove(s);
            }
        }*/

        /*for (String s : list) {
            if ("周芷若".equals(s))
            {
                list.remove(s);
            }
        }*/

        //正确做法

       /* Iterator<String> i = list.iterator();
        while (i.hasNext()){
            String s = i.next();
            if (s.equals("周芷若")){
                i.remove();
            }
        }
        System.out.println(list);*/

        for (int i = list.size() - 1; i >= 0 ; i--) {
            if ("周芷若".equals(list.get(i))){
                list.remove(i);
            }
        }
        System.out.println(list);

    }
}
