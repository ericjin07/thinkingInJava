package com.eric.holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 11:19 AM
 */
public class Vowels16 {

    public static void vowelConter(Set<String> st) {
        Set<Character> vowels = new HashSet<>();
        Collections.addAll(vowels,'A','E','I','O','U','a','e','i','o','u');
        Map<Character,Integer> vowelsMap = new TreeMap<>();
        int allCount = 0;
        for (String s : st) {
            //single word
            for (Character c : s.toCharArray()) {
                if (vowels.contains(c)) {
                    allCount++;
                    Integer cnt = vowelsMap.get(c);
                    vowelsMap.put(c,cnt == null ? 1 : cnt + 1);
                }
            }
        }
        System.out.println("the input has " + allCount + " vowels");
        System.out.println(vowelsMap);
    }

    public static void main(String[] args) {
        Set<String> vowels = new HashSet<>(new TextFile("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\holding\\Ex11.java","\\W+"));
        vowelConter(vowels);
    }
}
