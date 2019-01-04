package com.eric.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 9:45 PM
 */
public class Reseting {

    public static void main(String[] args) {
        Matcher m = Pattern.compile("[frb][aiu][gx]").matcher("fix the rug with bags");
        while (m.find())
            System.out.print(m.group() + " ");
        System.out.println();
        String i = "fasdfasd" +
                "fsadfasdf" +
                "fasdf";
        m.reset("fix the rig with rags");
        while (m.find())
            System.out.print(m.group() + " ");
    }
}
