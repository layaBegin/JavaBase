package com.heima.thread_commution;

public class DrawThread  extends Thread{
    private Account account;
    public DrawThread(Account account, String name){
        super(name);
        this.account = account;

    }

    @Override
    public void run() {
        while (true){
            try {
                account.drawMoney(10000);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }




}
