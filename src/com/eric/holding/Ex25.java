package com.eric.holding;

import net.mindview.util.TextFile;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 2:48 PM
 */
public class Ex25 {

    public static void main(String[] args) {
        List<String> files = new ArrayList<>(new TextFile("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\holding\\Ex24.java","\\W+"));
        Map<String,ArrayList<Integer>> words = new LinkedHashMap<>();
        Iterator<String> itr = files.iterator();
        String w = "";
        int count = 0;
        ArrayList<Integer> intr;
        while (itr.hasNext()) {
            w = itr.next();
            if (words.get(w) == null) {
                intr = new ArrayList<>();
                intr.add(count);
                words.put(w,intr);
            } else {
                intr = words.get(w);
                intr.add(count);
            }
            count++;
        }
        System.out.println(words);
    }
}
