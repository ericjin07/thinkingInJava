package com.eric.holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 9:53 PM
 */
public class Ex21 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(new TextFile("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\holding\\Vowels16.java","\\W+"));
        Collections.sort(words,String::compareToIgnoreCase);
        Map<String,Integer> wordCnt = new LinkedHashMap<>();
        for (String s : words) {
            Integer cnt = wordCnt.get(s);
            wordCnt.put(s, cnt == null ? 1 : cnt + 1);
        }
        System.out.println(wordCnt);
    }
}
