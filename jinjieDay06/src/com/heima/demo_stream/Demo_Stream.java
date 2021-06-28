package com.heima.demo_stream;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**Stream 流的3类方法
 * 1，创建一条流水线，并把数据放到流水线上
 * 2，中间方法，流水线上的操作
 * 3，终结方法：流水线上的最后一个操作，一个流水线只能有一个终结方法
 */
public class Demo_Stream {
    public static void main(String[] args) {
        //Collection 集合获取流
        Collection<String> c = new ArrayList<>();
        c.add("lishi");
        c.add("wangwu");

        Stream<String> s = c.stream();

        //Map 获取流
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        Stream<String> s1 = map.keySet().stream();
        Stream<Integer> stream1 = map.values().stream();
        Stream<Map.Entry<String, Integer>> stream = map.entrySet().stream();

        //数组获取流
        int[] arr = new int[]{1,4,5};
        IntStream stream2 = Arrays.stream(arr);
        String[] sArr = new String[]{"30","rer","fdf"};
        Stream<String> stream3 = Arrays.stream(sArr);
        Stream<String> sArr1 = Stream.of(sArr);

        //流的收集
        List<String> list = new ArrayList<>();
        list.add("赵麻子");
        list.add("张山");
        list.add("李氏");
        list.add("张山峰");
        list.add("张山峰");
        list.add("张飞");

        List<String> zhang = list.stream().filter(s2 -> s2.startsWith("张")).collect(Collectors.toList());
        System.out.println(zhang);
        Set<String> zhang1 = list.stream().filter(s2 -> s2.startsWith("张")).collect(Collectors.toSet());
        System.out.println(zhang1);
        Object[] zhang2 = list.stream().filter(s2 -> s2.startsWith("张")).toArray();
        System.out.println(Arrays.toString(zhang2));

        /**
         * -----------拓展------------------------
         */
        /*String[] zhang3 = list.stream().filter(s2 -> s2.startsWith("张")).toArray(new IntFunction<String[]>() {
                                                                                     @Override
                                                                                     public String[] apply(int value) {
                                                                                         return new String[0];
                                                                                     }
                                                                                 }
        );*/
       /* String[] zhang3 = list.stream().filter(s2 -> s2.startsWith("张")).toArray((value)->
                new String[value]
        );*/
         String[] zhang3 = list.stream().filter(s2 -> s2.startsWith("张")).toArray(String[]::new

        );
        System.out.println(Arrays.toString(zhang3));
    }
}
