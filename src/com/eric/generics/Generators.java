package com.eric.generics;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 3:25 PM
 */
public class Generators {

    public static <T> Collection<T> fill(Collection<T> list, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            list.add(generator.next());
        }
        return list;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            set.add(generator.next());
        }
        return set;
    }

    public static void main(String[] args) {
        Collection<Integer> fib = fill(new ArrayList<>(),new Fibonacci_7(), 10);
        for (Integer i : fib)
            System.out.print(i + " ");

        Set<StoryCharacters_8> characters = fill(new HashSet<>(), new StoryCharacterGenerator_8(), 10);
        for (StoryCharacters_8 s : characters)
            System.out.println(s);
    }
}
