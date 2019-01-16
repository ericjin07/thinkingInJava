package com.eric.typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/09/2019 10:27 PM
 */
class CountInteger {
    private static int count;
    private final int id = count++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }

    public List<T> creatList(int size) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            try {
                list.add(type.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FilledList<CountInteger> filledList = new FilledList<>(CountInteger.class);
        List<CountInteger> list = filledList.creatList(100);
        System.out.println(list);
    }
}
