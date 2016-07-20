package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class Singleton {
    public static int id = 0;
    private volatile static Singleton singleton;

    private Singleton() {
        id++;
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
