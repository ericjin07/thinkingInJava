package com.eric.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/19/2019 7:50 PM
 */
public class CacheThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
