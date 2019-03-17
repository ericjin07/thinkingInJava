package com.eric.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/07/2019 10:59 AM
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        PriorityBlockingQueue<PriorityTask> queue = new PriorityBlockingQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new PriorityTaskConsumer(queue));
        exec.execute(new PriorityTaskProducer(queue,exec));
    }
}

class PriorityTask implements Runnable,Comparable<PriorityTask> {
    private static int counter;
    private final int priority;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private static List<PriorityTask> sequence = new ArrayList<>();

    public PriorityTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(PriorityTask o) {
        return -Integer.compare(priority,o.priority);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(100));
        } catch (InterruptedException e) {
            System.out.println("Interrupted by sleep");
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Task-%-4d [%d]",id,priority);
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PriorityTask {
        private ExecutorService exec;

        public EndSentinel(ExecutorService executorService) {
            super(-1);
            this.exec = executorService;
        }

        @Override
        public void run() {
            int count = 0;
            for (PriorityTask p : sequence){
                System.out.print(p.summary());
                if (++count % 5 == 0) System.out.println();
            }
            System.out.println(this + " callings shutdownNow()");
            exec.shutdownNow();
        }
    }

}

class PriorityTaskProducer implements Runnable {

    private PriorityBlockingQueue<PriorityTask> queue;
    private ExecutorService exec;
    private static Random rand = new Random(47);

    public PriorityTaskProducer(PriorityBlockingQueue<PriorityTask> queue, ExecutorService exec) {
        this.queue = queue;
        this.exec = exec;
    }

    @Override
    public void run() {
        //fill random
        for (int i = 0; i < 10; i++) {
            queue.add(new PriorityTask(rand.nextInt(10)));
            Thread.yield();
        }
        //fill highest
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            queue.add(new PriorityTask(10));
        }
        //fill lowest
        for (int i = 0; i < 10; i++)
            queue.add(new PriorityTask(i));
        //fill end sentinel
        queue.add(new PriorityTask.EndSentinel(exec));
        System.out.println("Finish PriorityTask Producer");
    }
}

class PriorityTaskConsumer implements Runnable {

    private PriorityBlockingQueue<PriorityTask> queue;

    public PriorityTaskConsumer(PriorityBlockingQueue<PriorityTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                queue.take().run();
        } catch (InterruptedException e) {
            System.out.println("Interruption on take");
        }
        System.out.println("Finished Priority Task Consumer");
    }
}


