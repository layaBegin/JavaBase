package com.heima.genericity_class;

import java.util.ArrayList;

/**
 * 定义时 泛型，将所有出现 泛型符号 如 T 的地方替换成传入的类型
 *
 *  使用 泛型 可以用 ？ 通配符 代表，extends 规定上限
 */
public class Demo_genericity {
    public static void main(String[] args) {
       /* DleiArrayList<Integer> d = new DleiArrayList<>();
        d.add(1);*/

        /*String[] sArr = {"ji","ya","ee"};
        Integer[] iArr = {1,3,4};
        String s= Demo_genericity.toString(sArr);
        System.out.println(s);
        System.out.println(toString(iArr));*/

        ArrayList<BMW> bmws = new ArrayList<>();
        didi(bmws);
        ArrayList<Benz> benzs = new ArrayList<>();
        didi(benzs);
        ArrayList<Dog> dogs = new ArrayList<>();
        //didi(dogs);// 报错，必须继承car

    }

    /**
     * 泛型方法
     * @param arr
     * @param <T>
     * @return
     */
    public static  <T> String toString(T[] arr){
        String s = "[";
        for (int i = 0; i < arr.length ; i++) {
            s += i;
            if (i < arr.length -1){
                s+= "/";
            }
        }
        s+="]";
        return s;
    }


    public static void didi(ArrayList< ? extends Car> car){

    }

}

/**
 * 泛型使用时 可以用 ？ 通配符 代表
 */

abstract class Car{
    abstract void go();
}
class BMW extends Car{

    @Override
    void go() {

    }
}
class Benz extends Car{

    @Override
    void go() {

    }
}

class Dog{

}