package com.heima.unchange_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 不可变集合， 调用of（）
 */
public class Demo_unchange_Collection {
    public static void main(String[] args) {
        List<String> list = List.of("zhangshan","lishi","wangwu");
        System.out.println(list);
        //报错
        //list.add("12");
    }
}
