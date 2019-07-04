package com.eric.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/19/2019 9:46 AM
 */
public class TryResources {

    public static void main(String[] args) {
        System.out.println(firstLineOff("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\IO\\Singleton.java"));
        myClean();
    }

    private static String firstLineOff(String path) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path)
        )){
            return br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void myClean() {
        try(Cleaners cl = new Cleaners()){
            cl.setLd("haha");
            System.out.println(cl);
        }
    }
}
