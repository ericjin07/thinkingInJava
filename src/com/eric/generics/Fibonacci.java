package com.eric.generics;

import javax.sound.midi.Soundbank;
import java.util.Iterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 11:31 AM
 */
public class Fibonacci implements Generator<Integer>, Iterable<Integer> {
    private static int count = 0;
    private int size;

    public Fibonacci(int size) {
        this.size = size;
    }

    public Fibonacci() {
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
        Fibonacci gen = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.print(gen.next() + " ");
        }

        for (Integer i : new Fibonacci(10)) {
            System.out.println(i + " ");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator();
    }

    class FibonacciIterator implements Iterator<Integer> {
        int n = size;
        @Override
        public boolean hasNext() {
            return n > 0;
        }

        @Override
        public Integer next() {
            n--;
            return Fibonacci.this.next();
        }
    }
}
