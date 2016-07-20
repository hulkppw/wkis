package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class AddMoneyThread implements Runnable {

    private Account account;
    private double money;
    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }
    @Override
    public void run() {
        account.deposit(money);
    }
}
