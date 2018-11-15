package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 8:46 PM
 */
/* Create a class that holds a String, and has a toString() method that
 * displays this String. Add several instances of your new class to a
 * Sequence ojbect, then display them.
 */
/*
implement ReverseSelector
 */
class Word{
    private String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}

public class Sequence_ex2 {
    private Object items[];
    private int next = 0;

    public Sequence_ex2(int size) {
        items = new Object[size];
    }

    public void add(Object item){
        if (next < items.length)
            items[next++] = item;
    }

    private class ReverseSelector implements Selector{
        private int i = items.length - 1;
        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i >= 0)
                i--;
        }
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
    }

    public Selector selector(){
        return new SequenceSelector();
    }

    public Selector reverSelector(){
        return new ReverseSelector();
    }

    public static void main(String[] args) {
        Sequence_ex2 sequence = new Sequence_ex2(10);
//        for (int i = 0; i < 10; i++) {
//            sequence.add(new Word(i + "-=-"));
//        }
//        Selector selector = sequence.selector();
//        while(!selector.end()) {
//            System.out.print(selector.current() + " ");
//            selector.next();
//        }
//        Word word1 =new Word("hello");
//        Word word2 =new Word("world");
//        Word word3 =new Word("peace");
//        Sequence_ex2 sequence1 = new Sequence_ex2(3);
//        sequence1.add(word1);
//        sequence1.add(word2);
//        sequence1.add(word3);
//        Selector selector1 = sequence1.selector();
//        System.out.println("================");
//        while(!selector1.end()) {
//            System.out.print(selector1.current() + " ");
//            selector1.next();
//        }
        System.out.println("\n---------------------------");
        for (int i = 0; i < 10; i++) {
            sequence.add(new Word(i*31 + "-====-"));
        }
        Selector reverseSelector = sequence.reverSelector();
        while(!reverseSelector.end()){
            System.out.println(reverseSelector.current());
            reverseSelector.next();
        }

    }
}
