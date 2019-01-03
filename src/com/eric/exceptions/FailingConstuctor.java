package com.eric.exceptions;

import javax.xml.transform.Result;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/26/2018 9:49 PM
 */
public class FailingConstuctor {

    private BufferedReader in;
    private Disposable disposable1;
    private Disposable disposable2;
    private int[] arr = new int[2];

    public FailingConstuctor() {
        try {
            disposable1 = new Disposable();
            try {
                arr[3] = 2;
                try {
                    disposable2 = new Disposable();
                } catch (Exception e) {
                    System.out.println("2 was constructed failed");
                }
            } catch (Exception e) {
                System.out.println("1 was constructed success");
                disposable1.dispose();
                System.out.println(disposable1);
                e.printStackTrace(System.out);
            }
        } catch (Exception e) {
            System.out.println("1 was constructed failed");
        }
    }

    public FailingConstuctor(String file) throws Exception {
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("the file not found,did'n opened");
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            System.out.println("another exception, the file is open,need to close");
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close was failed");
            }
        }
    }

    public String getLine() {
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine failed");
        }
        return line;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("in.close success");
        } catch (IOException e) {
            System.out.println("in.close failed");
        }
    }

    public static void main(String[] args) {
        FailingConstuctor fcc = new FailingConstuctor();
        try {
            FailingConstuctor fc = new FailingConstuctor("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\exceptions\\InputFile.java");
            try {
                String line = "";
                while((line = fc.getLine()) != null)
                    System.out.println(line);
            } catch (Exception e) {
                System.out.println("catch in main of the read file");
            } finally {
                fc.dispose();
            }
        } catch (Exception e) {
            System.out.println("Constructor failed");
        }
    }
}

class Disposable {

    private boolean disposed;

    Disposable() {
        disposed = false;
    }

    public void dispose() {
        disposed = true;
    }

    @Override
    public String toString() {
        return "Disposable{" +
                "disposed=" + disposed +
                '}';
    }
}