package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class BasicThread {
    public static void main(String[] args){
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
