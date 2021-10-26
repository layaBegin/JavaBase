package com.heima;

public class BuyTiceket {
    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        Thread t1 = new Thread(sellTicket, "窗口1");
        Thread t2 = new Thread(sellTicket, "窗口2");
        t1.start();
        t2.start();

    }
}
