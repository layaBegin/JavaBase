package com.heima.demo_logback;

public class Demo_Logback {
    public static void main(String[] args) {
        chu(10,0);
    }

    public static int chu(int a,int b){
        int c = -1;
        try {
            c = a/b;
            ServiceDemo.LOGGER.info("a:"+a);
            ServiceDemo.LOGGER.info("b:"+b);
            ServiceDemo.LOGGER.info("c:"+ c);
        } catch (Exception e) {
            e.printStackTrace();
            ServiceDemo.LOGGER.info("error is 18行：" + e.getMessage());
        }
        return c;

    }
}
