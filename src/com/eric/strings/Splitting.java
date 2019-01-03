package com.eric.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/02/2019 7:23 PM
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herrinA!";

    public static void main(String[] args) {
        split("\b");
        split(" ");
        split("\\W+");
        split("t\\W+");
        split("the");
        System.out.println(knights.replaceAll("f\\w+","==="));
        System.out.println(knights.replaceAll("[aeiou|AEIOU]","_"));
        System.out.println("Sfd.".matches("^[A-Z].*[\\.]$"));
        System.out.println("Sfd".matches("^[A-Z].*[\\.]$"));
        System.out.println("dfd,".matches("^[A-Z].*[\\.]$"));
        System.out.println("sfd.".matches("^[A-Z].*[\\.]$"));
        System.out.println("dfsfd.".matches("^[A-Z].*[\\.]$"));
        System.out.println("fadf\f");

    }

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }
}
