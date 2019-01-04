package com.eric.strings;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 9:15 PM
 */
/*! Here’s a block of   text to use as input to
the regular expression matcher. Note that we’ll
first extract the block of text by looking for
the special delimiters, then process the
extracted block. !*/

public class TheReplacement {

    public static void main(String[] args) {
        String s = TextFile.read("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\strings\\TheReplacement.java");
        Matcher m = Pattern.compile("/\\*!(.*)!\\*/",Pattern.DOTALL).matcher(s);
        while (m.find())
            s = m.group(1);
        s = s.replaceAll(" {2,}"," ");
        s = s.replaceAll("(?m)^ +","");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]","(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher matcher = p.matcher(s);
        while (matcher.find())
            matcher.appendReplacement(sbuf, matcher.group().toUpperCase());
        matcher.appendTail(sbuf);
        System.out.println(sbuf);
    }

}
