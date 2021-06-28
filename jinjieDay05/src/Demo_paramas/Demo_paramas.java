package Demo_paramas;

import java.util.Arrays;

/**
 * 可变参数
 *  底层时数组
 */
public class Demo_paramas {
    public static void main(String[] args) {
        add(3);
        add(4,5,8);
        add(new int[]{6,9,0});
    }


    public static void add(int... a){
        System.out.println(Arrays.toString(a));
    }
    //报错
    /*public static void add1(int... a,int age){
        System.out.println(Arrays.toString(a));
    }*/

    //两个参数正确写法
    public static void add1(int age,int... a){
        System.out.println(Arrays.toString(a));
    }

}
