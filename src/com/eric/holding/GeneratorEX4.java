package com.eric.holding;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/27/2018 8:22 PM
 */
public class GeneratorEX4 {

    int key;
    public String next(){
        switch (key){
            default:
            case 0: key++; return  "英雄本色";
            case 1: key++; return  "赌圣";
            case 2: key++; return  "黑马";
            case 3: key++; return  "爱丽丝";
            case 4: key++; return  "刺客信条";
            case 5: key=0; return  "鬼泣";
        }

    }

    public Collection<String> fill(Collection<String> c, int n){
        for (int i = 0; i < n; i++)
            c.add(next());
        return c;
    }

    public static void main(String[] args) {
        GeneratorEX4 ge = new GeneratorEX4();
        Collection<String> c ;
        System.out.println(ge.fill(new ArrayList<>(),10));
        System.out.println(ge.fill(new LinkedList<>(),10));
        System.out.println(ge.fill(new HashSet<>(),10));
        System.out.println(ge.fill(new LinkedHashSet<>(),10));
        System.out.println(ge.fill(new TreeSet<>(),10));
    }
}
