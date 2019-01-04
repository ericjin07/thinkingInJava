package com.eric.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 2:03 PM
 */
public class TestRegularExpression {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\njava TestRegularExpression");
            System.exit(0);
        }
        System.out.println("input: \"" + args[0] + "\"");
        for (String arg : args) {
            System.out.println("Regular Expression: \"" + arg + "\"");
            Pattern p = Pattern.compile(arg);
            Matcher m  = p.matcher(args[0]);
            while (m.find()) {
                System.out.println("Match \"" + m.group() + "\" at positions " +
                        m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
