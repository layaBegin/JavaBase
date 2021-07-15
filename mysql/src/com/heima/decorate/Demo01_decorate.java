package com.heima.decorate;

public class Demo01_decorate {
    public static void main(String[] args) {
        BaoQiang baoQiang = new BaoQiang();
        MyProxy myProxy = new MyProxy(baoQiang);
        myProxy.play(300);

        JiaNaiLiang jiaNaiLiang = new JiaNaiLiang();
        MyProxy myProxy1 = new MyProxy(jiaNaiLiang);
        myProxy1.play(300);
    }
}
