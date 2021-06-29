package com.heima.thread_commution;

public class SaveThread extends Thread{
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    private Account account;


    public SaveThread(Account account,String name){
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        while (true){
            try {
                this.account.saveMoney(10000);
                System.out.println("");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
