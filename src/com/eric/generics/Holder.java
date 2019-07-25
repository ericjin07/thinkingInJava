package com.eric.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/16/2019 8:22 PM
 */
public class Holder<T> {
    private T value;

    public Holder(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    public static void main(String[] args) {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple a = appleHolder.getValue();
        appleHolder.setValue(a);

//        Holder<Fruit> fruitHolder = appleHolder;

        Holder<? extends Fruit> holder = appleHolder;
        Fruit f = holder.getValue();
        a = (Apple) holder.getValue();
//        holder.setValue(new Apple());
//        holder.setValue(new Fruit());
        System.out.println(holder.equals(a));

        List<Apple> apples = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        writeExact(apples, new Apple());
        writeExact(apples, new Jonathan());
    }

    static <T> void writeExact(List<? super T> list, T item) {
        list.add(item);
    }
}
