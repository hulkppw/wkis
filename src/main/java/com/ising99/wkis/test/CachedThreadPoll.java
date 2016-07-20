package com.ising99.wkis.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vincen on 2016/5/11.
 */
public class CachedThreadPoll {
    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            service.execute(new LiftOff());
        }
        service.shutdown();
        System.out.println("Waiting for LiftOff");
    }
}
