package com.eric.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/08/2019 9:59 PM
 */
interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy {
    private int i;
//    public Toy() {
//    }
    public Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
public String fs;
    public FancyToy() {
        super(1);
    }
}
public class ToyTestEx1 {

    public static void printInfo(Class clz) {
        System.out.println("Class name: " + clz.getName() + " is interface? [" + clz.isInterface() + "]");
        System.out.println("Simple name: " + clz.getSimpleName());
        System.out.println("CanonicalName name: " + clz.getCanonicalName());
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = null;
        try {
            c = Class.forName("com.eric.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can't found FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class itf : c.getInterfaces())
            printInfo(itf);
        Class up = c.getSuperclass();
        Object obj = null;
//        try {
            //obj = up.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//            System.out.println("Can not instantiate");
//            System.exit(1);
//        } catch (IllegalAccessException e) {
//            System.out.println("Can not access");
//            System.exit(1);
//        }
//        printInfo(obj.getClass());

        //use reflection
        try {
            obj = up.getDeclaredConstructor(int.class).newInstance(2);
            System.out.println(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
