package com.eric.innerclasses;

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
    private Object items[];
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object item){
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

        public Sequence out(){
            return Sequence.this;
        }
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        ((SequenceSelector)selector).out().test();
        DotThis dotThis = new DotThis();
        //in another class the Inner class need (DotThis.) else the compiler can't configure what this is
        DotThis.Inner inner = dotThis.new Inner();
        inner.out().f();
    }
}
