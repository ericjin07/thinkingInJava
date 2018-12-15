package com.eric.holding;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/10/2018 9:38 PM
 */
public class Ex11 {

    public static void printAny(Collection c){
        Iterator itr = c.iterator();
        while (itr.hasNext())
            System.out.print(itr.next().toString() + " ,");
        System.out.println("\n-=======-");
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,2,3,4));
        LinkedList<Character> ll = new LinkedList<>(Arrays.asList('a','b','r','y'));
        HashSet<Float> hs = new HashSet<Float>(Arrays.asList(1.2f,2.4f,4.5f));
        TreeSet<Double> ts = new TreeSet<>(Arrays.asList(7.8,6.9,2.33));
        printAny(al);
        printAny(ll);
        printAny(hs);
        printAny(ts);
    }
}
