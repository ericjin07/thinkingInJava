package com.eric.containers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/17/2019 11:12 PM
 */
public class CanonicalMapping {

    public static void main(String[] args) throws InterruptedException {
        int size = 100;
        Key[] keys = new Key[size];
        WeakHashMap<Key,Value> map = new WeakHashMap<>();
//        Map<Key,Value> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            Key k = new Key(i);
            Value v = new Value(i);
            if (i % 2 == 0) keys[i] = k;
            map.put(k,v);
        }
        System.gc();
        TimeUnit.MILLISECONDS.sleep(100);
    }
}

class Element {
    private final int id;

    public Element(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return id == element.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing : " + getClass().getSimpleName() + " " + id);
    }
}

class Key extends Element {
    public Key(int id) {
        super(id);
    }
}

class Value extends Element {
    public Value(int id) {
        super(id);
    }
}
