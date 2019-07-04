package com.eric.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 3:16 PM
 */
public class GroupsEx12 {

    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+\\b");
        Matcher m = p.matcher(POEM);
        Set<String> word = new HashSet<>();
        while (m.find()) {
            word.add(m.group());
            System.out.println(m.group());
        }
        System.out.println(word.size());
        System.out.println(word);
    }
}
