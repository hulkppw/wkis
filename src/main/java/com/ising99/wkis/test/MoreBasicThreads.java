package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new LiftOff());
            t.start();
        }

        System.out.println("Waiting for LiftOff");
    }
}
