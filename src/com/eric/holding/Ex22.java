package com.eric.holding;

import net.mindview.util.TextFile;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 9:53 PM
 */
public class Ex22 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(new TextFile("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\holding\\Vowels16.java","\\W+"));
        Collections.sort(words,String::compareToIgnoreCase);
        Set<Word> wordset = new HashSet<>();
        Iterator<String> itr = words.listIterator();
        while (itr.hasNext()){
            String s = itr.next();
            int count = 0;
            for (int i = 0; i < words.size(); i++)
                if (s.equals(words.get(i))) count++;
            wordset.add(new Word(s,count));
        }
        System.out.println(wordset);
        System.out.println(Word.totalCount);
    }
}

class Word{
    public static int totalCount;
    private String word;
    private int count;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
        totalCount++;
    }

    @Override
    public String toString() {
        return  "(" + word + ":" + count + ")";
    }
}
