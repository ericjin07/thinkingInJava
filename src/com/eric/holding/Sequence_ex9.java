package com.eric.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 8:46 PM
 */

public class Sequence_ex9 {
    private List items;
    private int next = 0;

    public Sequence_ex9(int size) {
        items = new ArrayList<>(size);
    }

    public void add(Object item){
        items.add(item);
    }

    public void test(){
        System.out.println("test the sequence");
    }

    public Iterator iterator(){
        return items.iterator();
    }

    public static void main(String[] args) {
        Sequence_ex9 sequence = new Sequence_ex9(20);
        for (int i = 0; i < 20; i++)
            sequence.add(Integer.toString(i));
        Iterator itr = sequence.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}
