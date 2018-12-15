package com.eric.holding;

import com.eric.innerclasses.DotThis;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 8:46 PM
 */
interface Selector{
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private List items;
    private int next = 0;

    public Sequence(int size) {
        items = new ArrayList<>(size);
    }

    public void add(Object item){
        items.add(item);
    }

    public void test(){
        System.out.println("test the sequence");
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size())
                i++;
        }

        public Sequence out(){
            return Sequence.this;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(20);
        for (int i = 0; i < 20; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }

    }
}
