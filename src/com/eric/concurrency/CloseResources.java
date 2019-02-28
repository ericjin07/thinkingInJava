package com.eric.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/27/2019 2:18 PM
 */
public class CloseResources {

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8079);
        InputStream socketStream = new Socket("localhost",8079).getInputStream();
        exec.execute(new IOBlocked(socketStream));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Shutdown all thread");
        exec.shutdownNow();
//        socketStream.close();
//        System.out.println("socket Stream closed");
        TimeUnit.SECONDS.sleep(3);
        System.in.close();
    }
}
