package com.heima.Demo_StringBuilder;

public class Demo_stringBuilder {
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder("reer");

        StringBuffer b1 = new StringBuffer("线程更安全，和StringBuilder差别不大");
        b.append("可以");
        b.append("D");
        System.out.println(b);
        b.reverse();
        System.out.println(b);
        String c = b.toString();
        System.out.println(c);
        System.out.println(b1);

    }
}
