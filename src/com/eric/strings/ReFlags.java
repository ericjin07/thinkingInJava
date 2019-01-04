package com.eric.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 8:48 PM
 */
public class ReFlags {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^Java",Pattern.CASE_INSENSITIVE|Pattern.MULTILINE);
        Matcher m = p.matcher(
                "java has regex\nJava has regex\n" +
                        "JAVA has pretty good regular expression\n" +
                        "Regular expressions are in JavA"
        );
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
