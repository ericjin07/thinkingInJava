package com.eric.typeinfo;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/08/2019 10:38 PM
 */
public class ObjHierarchy8 {

    private String ok;
    public static void main(String[] args) throws Exception {
        Class clz = null;
        clz = Class.forName("com.eric.typeinfo.FancyToy");
        getSuperClazz(clz);
    }

    public static void getSuperClazz(Class clz) {
        if (clz == null) return;
        else {
            getSuperClazz(clz.getSuperclass());
            System.out.println(clz.getName());
            System.out.println("all field");
            Field[] fields = clz.getDeclaredFields();
            for (Field f : fields)
                System.out.println(f.getName());
        }
    }
}
