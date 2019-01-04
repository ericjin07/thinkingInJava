package com.eric.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 11:09 PM
 */
public class CommentReadEx17 {

    //this is a comment
    //this is a comment
    /*
    fsadfasd
    fasdfsd
    fsd
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: CommentReadEx17, please input the FileName");
            System.exit(0);
        }   //|(/\*(.*)\*/\s+)

        Pattern p = Pattern.compile("(\\s+(//.*?\n))|(/\\*(.*?)\\*/\\s+)",Pattern.MULTILINE|Pattern.DOTALL);
        String s = TextFile.read(args[0]);
        Matcher m = p.matcher(s);
        while (m.find())
            System.out.println(m.group());
    }
}
