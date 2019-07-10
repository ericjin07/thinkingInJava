package com.eric.generics;

import java.util.Iterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 11:31 AM
 */
public class Fibonacci_7 implements Generator<Integer>, Iterable<Integer>{
    private static int count = 0;
    private int size;

    public Fibonacci_7(int size) {
        this.size = size;
    }

    public Fibonacci_7() {
    }

    @Override
    public Integer next() {
        return fib(count++);
    }

    private int fib(int count) {
        if (count < 2) return 1;
        else return fib(count-1) + fib(count-2);
    }

    public static void main(String[] args) {
        Fibonacci_7 gen = new Fibonacci_7();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }

        for (Integer i : new Fibonacci_7(10)) {
            System.out.println(i + " ");
        }
    }


    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Integer next() {
                size--;
                return Fibonacci_7.this.next();
            }
        };
    }

}
