package com.eric.strings;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/04/2019 11:15 AM
 */
public class ThreatData {

    static String threatData =
            "58.27.82.161@02/10/2005\n" +
                    "204.45.234.40@02/11/2005\n" +
                    "58.27.82.161@02/11/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "58.27.82.161@02/12/2005\n" +
                    "[Next log section with different data format]";

    public static void main(String[] args) {
        String p = "(\\d{1,3}[.]\\d{1,3}[.]\\d{1,3}[.]\\d{1,3})@(\\d{2}/\\d{2}/\\d{4})";
        Scanner s = new Scanner(threatData);
        while (s.hasNext(p)) {
            s.next(p);
            MatchResult mr = s.match();
            System.out.printf("Threat on %s from %s\n",mr.group(1),mr.group(2));
        }
    }
}
