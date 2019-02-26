package com.eric.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/19/2019 8:16 PM
 */
public class TaskForResult implements Callable<String> {

    private static int taskCount = 0;
    private final  int id = taskCount++;

    @Override
    public String call() throws Exception {
        return "the result is " + id;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskForResult()));
        }
        for (Future<String> f : results){
            try {
                if (f.isDone())
                    System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
//                exec.shutdown();
            }
        }
    }
}
