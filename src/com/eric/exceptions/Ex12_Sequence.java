package com.eric.exceptions;

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

public class Ex12_Sequence {
    private Object items[];
    private int next = 0;

    public Ex12_Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object item){
        if (next == items.length) throw new ArrayIndexOutOfBoundsException();
        if (next < items.length)
            items[next++] = item;
    }

    public void test(){
        System.out.println("test the sequence");
    }

    private class SequenceSelector implements Selector {
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }

        public Ex12_Sequence out(){
            return Ex12_Sequence.this;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Ex12_Sequence sequence = new Ex12_Sequence(10);
        for (int i = 0; i < 11; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        ((SequenceSelector)selector).out().test();
    }
}
