package com.heima.visibility_synchronized;

public class WifeThread extends Thread{
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int money = 100000;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        money -= 10000;
        System.out.printf(Thread.currentThread() + "拿了1万去做头发 ，剩余："+this.money);
    }
}
