package com.eric.strings;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/02/2019 6:28 PM
 */
public class Hex {

    public static void main(String[] args) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\strings\\WitherStringBuilder.java"));
        byte[] data = new byte[in.available()];
        in.read(data);
        String result = format(data);

        System.out.println(result);
    }

    private static String format(byte[] data) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                sb.append(String.format("%05X: ", n));
            sb.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0)sb.append('\n');
        }
        return sb.toString();
    }
}
