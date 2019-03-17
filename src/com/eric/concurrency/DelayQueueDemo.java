package com.eric.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/06/2019 4:45 PM
 */
public class DelayQueueDemo {

    private static Random rand = new Random(47);

    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            queue.put(new DelayTask(rand.nextInt(5000)));
        }
        queue.put(new DelayTask.EndSentinel(5000,exec));
        exec.execute(new DelayTaskConsumer(queue));
    }
}

//apply the consumer
class DelayTaskConsumer implements Runnable {
    private DelayQueue<DelayTask> delayeds;

    public DelayTaskConsumer(DelayQueue<DelayTask> delayeds) {
        this.delayeds = delayeds;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted())
                delayeds.take().run();  //run the task in the current Thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish the DelayTask Consumer");
    }
}

//the delay task
class DelayTask implements Runnable, Delayed{
    private static int counter;
    private final int id = counter++;
    private final int delta;  //delay milli
    private final long trigger;
    private static List<DelayTask> sequence = new ArrayList<>();

    public DelayTask(int delta) {
        this.delta = delta;
        //convert milliseconds to nanoseconds
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta,TimeUnit.MILLISECONDS);
        //add to list
        sequence.add(this);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask t = null;
        if (o instanceof DelayTask) {
            t = (DelayTask) o;
        }
        if (t != null) {
            if (this.delta > t.delta) return 1;
            if (this.delta < t.delta) return -1;
        }
        return 0;
    }

    @Override
    public void run() {
        System.out.print(this + " ");
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }
    @Override
    public long getDelay(TimeUnit unit) {
        //convert to what the unit want
        return unit.convert(trigger - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public String toString() {
        return String.format("Task-%d [%-4d]",id,delta);
    }

    //the end sentinel
    public static class EndSentinel extends DelayTask {

        private ExecutorService exec;

        public EndSentinel(int delta, ExecutorService exec) {
            super(delta);
            this.exec = exec;
        }

        @Override
        public void run() {
            for (DelayTask d : sequence){
                System.out.println(d.summary());
            }
            System.out.println(this + " calling shutdownNow");
            exec.shutdownNow();
        }
    }
}
