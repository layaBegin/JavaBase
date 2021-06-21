import java.sql.SQLOutput;

public class StringBuilderDemo {
    public static void main(String[] args) {
//        int a = 10;
//        String s = "dfd";
//        testString(a,s);
//        System.out.println(a);
//        System.out.println(s);
        stringBuilderTest();
    }

    public static void  stringBuilderTest(){
        StringBuilder sb = new StringBuilder();
        sb.append("hello").append("world");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String s = sb.toString();//stringBuilder 转为string
        System.out.println(s);
        String s1 = "he";
        StringBuilder sb1 = new StringBuilder(s1);//string 转为stringBuilder
        System.out.println(sb1);
    }

    public static void testString(int a,String s){
        int b = 4;
        a+= b;
        System.out.println(a);
        s+= "world";
        System.out.println(s);
    }

    /*
     *string 和StringBuilder 的区别
        由于string 不可变，每次 + 操作都会在堆中开辟新的空间，比较浪费
     * */
    public static void stringSave(){
        String a = "hello";//"hello" 字符串常量在堆中 在0x01的地址 存放
        a+= "world";//"world" 字符串常量在堆中 在0x02的地址 存放
        System.out.println(a);//"helloworld" 字符串常量在堆中 在0x03的地址 存放
    }
}
