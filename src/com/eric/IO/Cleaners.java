package com.eric.IO;

import java.io.File;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/19/2019 9:50 AM
 */
public class Cleaners implements AutoCloseable{

    private String ld = "";

    public void setLd(String ld) {
        this.ld = ld;
    }

    @Override
    public String toString() {
        return "Cleaners{" +
                "ld='" + ld + '\'' +
                '}';
    }

    @Override
    public void close() {
        System.out.println("closing--------");
    }
}
