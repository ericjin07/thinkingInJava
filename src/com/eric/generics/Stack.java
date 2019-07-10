package com.eric.generics;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/05/2019 3:52 AM
 */
public class Stack<E> {

    private Object[] elements ;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public Stack(int capacity) {
        if (capacity > 0)
            elements = new Object[capacity];
        else throw new IllegalArgumentException();
    }

    public void push(E o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        //push requires elements to be of type E, so cast is correct
        @SuppressWarnings("unchecked")
        E res = (E)elements[--size];
        elements[size] = null;
        return res;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            Arrays.copyOf(elements, size * 2);
        }
    }
}
