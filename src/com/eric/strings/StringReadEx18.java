package com.eric.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 11:09 PM
 */
public class StringReadEx18 {

    //this is a comment
    //this is a comment
    /*
    fsadfasd
    fasdfsd
    fsd
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: StringReadEx18, please input the FileName");
            System.exit(0);
        }

        Pattern p = Pattern.compile("(\".*?\")",Pattern.MULTILINE|Pattern.DOTALL);
        Matcher m = p.matcher("");
        int i = 0;
        for (String line : new TextFile(args[0])){
            m.reset(line);
            while (m.find())
                System.out.println(i++  + " ===== " + m.group());
        }

        System.out.println("=======================================");
        i = 0;
        String s = TextFile.read(args[0]);
        m.reset(s);
        while (m.find())
            System.out.println(i++  + " ===== " + m.group());
    }
}
