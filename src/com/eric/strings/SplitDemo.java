package com.eric.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 8:54 PM
 */
public class SplitDemo {

    public static void main(String[] args) {
        String input = "This !! unusual use !! of exclamation!! points";
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(input.split("!!")));

        System.out.println(Arrays.toString(Pattern.compile("!!").split(input,3)));
        System.out.println(Arrays.toString(input.split("!!",3)));
    }
}
