package com.eric.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 3:00 PM
 */
public class Finding {

    public static void main(String[] args) {
        Matcher m = Pattern.compile("(\\w+)").
                matcher("Evening is full of the linnet's wings");
        System.out.println(m.groupCount());
        while (m.find())
            System.out.print(m.group() + " - ");
        int i = 0;
        System.out.println();
        while (m.find(i)) {
            System.out.print(m.group() + " - ");
            i++;
        }
    }
}
