package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 5:03 PM
 */
public class BasicGenerator_14<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator_14(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator_14<>(type);
    }
}
