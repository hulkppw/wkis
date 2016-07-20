package com.ising99.wkis.test;

import java.util.concurrent.TimeUnit;

/**
 * Created by vincen on 2016/5/11.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {
    }
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+id + "("+(countDown > 0 ? countDown : "LiftOff!") +")";
    }
    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            //让出正在执行的线程
            //Thread.yield();
            //线程休眠
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }
}
