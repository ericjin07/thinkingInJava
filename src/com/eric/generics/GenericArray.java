package com.eric.generics;


/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 2:46 PM
 */
public class GenericArray<T> {

    private T[] arr;

    @SuppressWarnings("unchecked")
    public GenericArray(int size) {
        this.arr = (T[]) new Object[size];
        System.out.println(arr);
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
        GenericArray<Integer> gai = new GenericArray<>(10);
//        Integer[] ia = gai.rep();     //ClassCastException
        Object[] ia = gai.rep();

        Long[] longs = new Long[10];
        Object[] objects = longs;
        System.out.println(objects);
        Object[] obj = new Object[10];
        Long[] longs1 = (Long[]) obj;

    }
}
