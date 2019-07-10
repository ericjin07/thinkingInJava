package com.eric.generics;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 1:40 PM
 */
public class StoryCharacterGenerator_8 implements Generator<StoryCharacters_8>,Iterable<StoryCharacters_8> {
    @Override
    public Iterator<StoryCharacters_8> iterator() {
        return new Iterator<StoryCharacters_8>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public StoryCharacters_8 next() {
                size--;
                return StoryCharacterGenerator_8.this.next();
            }
        };
    }

    private static final Class[] characters = new Class[]{DarthVader.class, JabbaTheHut.class,
            LukeSkywalker.class, Yoda.class};

    private int size = 0;
    private static Random rand = ThreadLocalRandom.current();

    public StoryCharacterGenerator_8(int size) {
        this.size = size;
    }

    public StoryCharacterGenerator_8() {
    }

    @Override
    public StoryCharacters_8 next() {
        try {
            return (StoryCharacters_8) characters[rand.nextInt(characters.length)].newInstance();
        } catch (Exception e) {
           throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        StoryCharacterGenerator_8 gen = new StoryCharacterGenerator_8();
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
        System.out.println("------------------");
        for (StoryCharacters_8 c : new StoryCharacterGenerator_8(10)) {
            System.out.println(c);
        }
    }
}
