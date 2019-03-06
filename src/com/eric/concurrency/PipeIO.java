package com.eric.concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/04/2019 2:45 PM
 */
public class PipeIO {

    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Reader reader = new Reader(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(reader);
        TimeUnit.SECONDS.sleep(10);
        exec.shutdownNow();
    }
}

class Sender implements Runnable {
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true){
                for (char c = 'A'; c <= 'Z' ; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(200);
                }
            }
        }catch (IOException e) {
            System.out.println(e + " Sender writer Exception");
        } catch (InterruptedException e) {
            System.out.println(e + " Sender Sleep Exception");
        }
    }
}

class Reader implements Runnable{
    private PipedReader in;

    public Reader(Sender sender) throws IOException {
        in = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.print("Read: " + (char)in.read() + ",");
            }
        } catch (IOException e) {
            System.out.println(e + "Receiver read exception");
        }
    }
}