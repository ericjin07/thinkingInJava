package com.eric.strings;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 3:50 PM
 */
public class StartEndEx13 {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";


    private static class Display {
        private String reg;
        private boolean printed;

        public Display(String reg) {
            this.reg = reg;
            this.printed = false;
        }

        void display(String format, int start,int end) {
            if (!printed)
                System.out.println("reg : " + reg);
            System.out.printf(format,start,end);
        }
    }

    public static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find())
            d.display("find() " + m.group() + " from-to (%d, %d)",m.start(),m.end());
        if (m.lookingAt())
            d.display("lookingAt() " + m.group() + " from-to (%d, %d)",m.start(),m.end());
        if (m.matches())
            d.display("matches() " + m.group() + " from-to (%d, %d)",m.start(),m.end());
    }

    public static void main(String[] args) {
        for (String str : POEM.split("\n")) {
            System.out.println("input: " + str);
            for (String regex : new String[]{"\\w*ere\\w*",
                    "\\w*ever", "T\\w+", "Never.*?!"})
                examine(str,regex);
        }
    }
}
