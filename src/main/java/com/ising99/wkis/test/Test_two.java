package com.ising99.wkis.test;

/**
 * Created by vincen on 2016/5/11.
 */
public class Test_two {
    public static void main(String[] args) {

        Thread t = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.print(Thread.currentThread().getName());
                        for (int j = 0; j < 10; j++) {
                            if (j == 0)
                                System.out.print(j);
                            else
                                System.out.print(", " + j);
                        }
                    }
                }
        );
        t.start();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.print(Thread.currentThread().getName()+"我先走一步了！");
                    }
                }
        ).start();
        System.out.print(Thread.currentThread().getName());
    }


}
