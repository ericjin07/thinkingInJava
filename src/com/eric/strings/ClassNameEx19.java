package com.eric.strings;

import net.mindview.util.TextFile;

import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/04/2019 10:13 AM
 */
public class ClassNameEx19 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: class ClassNameEx19, please input the FileName");
            System.exit(0);
        }   //|(/\*(.*)\*/\s+)

        Pattern p = Pattern.compile("(\\s+(//.*?\n))|(/\\*(.*?)\\*/\\s+)",Pattern.MULTILINE|Pattern.DOTALL);
        Pattern q = Pattern.compile("class (.*)\\b",Pattern.MULTILINE|Pattern.DOTALL);
        Pattern o = Pattern.compile("(\".*?\")",Pattern.MULTILINE|Pattern.DOTALL);
        Matcher m = p.matcher("");
        Matcher m1 = q.matcher("");
        Matcher m2 = o.matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            m1.reset(line);
            m2.reset(line);
            while (m1.find() && !m.find() && !m2.find())
                System.out.println(m1.group());
        }

    }
}
