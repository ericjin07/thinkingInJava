package com.eric.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/06/2019 3:01 PM
 */
public class HorseRace {

    private List<Horse> horses = new ArrayList<>();
    private CyclicBarrier barrier;
    static final int FINISH_SIZE = 75;
    private ExecutorService exec = Executors.newCachedThreadPool();

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < FINISH_SIZE; i++) {
                    sb.append("=");
                }
                System.out.println(sb);
                for (Horse horse : horses){
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_SIZE){
                        System.out.println(horse + " won!!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        new HorseRace(5,10);
    }
}

class Horse implements Runnable{
    private static int counter;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private CyclicBarrier barrier;
    private int strides;

    public int getStrides() {
        return strides;
    }

    public Horse(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                synchronized (this){
                    strides += rand.nextInt(3);
                }
                System.out.println("wait" + id);
                barrier.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                '}';
    }

    public String tracks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStrides(); i++)
            sb.append("*");
        return sb.append(" ").append(id).toString();
    }
}
