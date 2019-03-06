package com.eric.concurrency.exercise;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/04/2019 2:45 PM
 */
public class PipeIO_Ex30 {

    public static void main(String[] args) throws Exception {
        BlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        Sender sender = new Sender(queue);
        Reader reader = new Reader(queue);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(reader);
        exec.execute(sender);
        TimeUnit.SECONDS.sleep(8);
        exec.shutdownNow();
    }
}

class Sender implements Runnable {
    private BlockingQueue<Character> out;

    public Sender(BlockingQueue<Character> out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            while (true){
                for (char c = 'A'; c <= 'Z' ; c++) {
                    out.put(c);
                    TimeUnit.MILLISECONDS.sleep(200);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender Sleep Exception");
        }
    }
}

class Reader implements Runnable{
    private BlockingQueue<Character> in;

    public Reader(BlockingQueue<Character> in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.print("Read: " + in.take() + ",");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}