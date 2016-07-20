package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class Account {
    private double balance;

    public void deposit(double money){
        double tempBalance = balance + money;
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance = tempBalance;
    }

    public double getBalance(){
        return balance;
    }
}
