package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class Test_three {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            Singleton singleton = Singleton.getInstance();
            System.out.println("singleton"+singleton.id);
            Protetype protetype = new Protetype();
            System.out.println("protetype"+protetype.id);
        }
    }
}
