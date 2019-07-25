package com.eric.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 2:53 PM
 */
public class GenericArrayWithTypeToken<T> {
    private T[] arr;
    private Class<T> kind;

    public GenericArrayWithTypeToken(Class<T> kind, int size) {
        this.kind = kind;
        arr = (T[]) Array.newInstance(kind, size);
    }

    public void put(int index, T item) {
        arr[index] = item;
    }

    public T get(int index) {
        return arr[index];
    }

    public T[] rep() {
        return arr;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        Integer[] ia = gai.rep();
        System.out.println(Arrays.toString(ia));
    }
}
