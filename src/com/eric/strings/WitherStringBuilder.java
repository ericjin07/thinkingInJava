package com.eric.strings;

import java.util.ArrayList;
import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/27/2018 8:42 PM
 */
public class WitherStringBuilder {

    public String implicit(String [] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i++)
            result += fields[i];
        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++)
            result.append(fields[i]);
        return result.toString();
    }

    public static Random rand = new Random(47);

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100))
                    .append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("]");
        return result.toString();
    }

}
