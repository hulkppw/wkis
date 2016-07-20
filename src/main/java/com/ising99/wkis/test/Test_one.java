package com.ising99.wkis.test;

import org.apache.ibatis.executor.ExecutorException;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by vincen on 2016/5/11.
 */
public class Test_one {
    public static void main(String[] args) {
        Account account = new Account();
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++){
            service.execute(new AddMoneyThread(account, 1));
        }
        service.shutdown();
        while (!service.isTerminated()){

        }
        System.out.println("账户余额: " + account.getBalance());
    }
}
