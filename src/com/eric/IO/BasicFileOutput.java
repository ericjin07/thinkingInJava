package com.eric.IO;

import java.io.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/13/2019 1:20 PM
 */
public class BasicFileOutput {

    private static String file = "D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\IO\\CopyFileUseNIO.java";

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(file));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 0;
        String s = "";
        while ((s = in.readLine()) != null)
            out.println(++lineCount + " : "  + s);
        out.close();
    }

}
