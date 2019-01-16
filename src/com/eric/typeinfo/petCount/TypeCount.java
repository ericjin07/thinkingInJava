package com.eric.typeinfo.petCount;

import typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/10/2019 11:09 PM
 */
public class TypeCount extends HashMap<Class<?>,Integer> {
    private Class<?> basetype;

    public TypeCount(Class<?> type) {
        this.basetype = type;
    }

    public void count(Object obj) {
        Class clz = obj.getClass();
        if (!basetype.isAssignableFrom(clz))
            throw new RuntimeException("not match");
        countClass(clz);
    }

    private void countClass(Class clz) {
        Integer i = get(clz);
        put(clz,i == null ? 1 : i + 1);
        Class superClz = clz.getSuperclass();
        if (superClz != null && basetype.isAssignableFrom(superClz))
            countClass(superClz);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<Class<?>,Integer> pair : entrySet()) {
            result.append(pair.getKey().getSimpleName())
                    .append("=")
                    .append(pair.getValue())
                    .append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("}");
        return result.toString();
    }

}
