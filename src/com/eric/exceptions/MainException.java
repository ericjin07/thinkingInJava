package com.eric.exceptions;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/27/2018 3:49 PM
 */
public class MainException {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\exceptions\\LostMessage.java");
        int i = 0;
        byte buff[] = new byte[1024];
        while ((i = fis.read(buff)) != -1)
            System.out.println(i + "  " + new String(buff));
    }
}
