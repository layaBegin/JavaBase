package com.heima.thread_safe;

public class DrawThread  extends Thread{
    private Account account;
    public DrawThread(Account account,String name){
        super(name);
        this.account = account;

    }

    @Override
    public void run() {
        System.out.println("取钱");

        account.drawMoney(10000,this.getName());


    }




}
