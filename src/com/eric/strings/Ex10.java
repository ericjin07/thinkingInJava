package com.eric.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 2:39 PM
 */
public class Ex10 {

    public static void main(String[] args) {
//        String str = "Java now has regular expressions";
//        String regxs[] = {"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?","s*","s+","s{4}","S{1}","s{0,3}"};
        String str = "Arline ate eight apples and one orange while Anita hadnt any";
        String regxs[] = {"(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b"};
        Pattern p ;
        for (String reg : regxs) {
            p = Pattern.compile(reg);
            Matcher m = p.matcher(str);
            if(!m.find())
                System.out.println("No match found for " + "\"" + reg + "\"");
            m.reset();
            while(m.find()) {
                System.out.println("Match \"" + m.group() + "\" at position " +
                        m.start() + ((m.end() - m.start() < 2) ? "" : ("-" + (m.end() - 1))));
            }
        }
    }
}
