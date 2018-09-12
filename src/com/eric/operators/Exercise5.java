package com.eric.operators;

import javax.xml.bind.SchemaOutputResolver;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/15/2018 21:58
 */
public class Exercise5 {

    public static void main(String[] args) {
        Dog dog1 = new Dog("spot","Ruff!");
        Dog dog2 = new Dog("scruffy","Wurf!");
        System.out.println(dog1.name + dog1.says);
        System.out.println(dog2.name + dog2.says);
        Dog dog3 = dog1;
        System.out.println(dog1 == dog3);
        System.out.println(dog1.equals(dog3));
        System.out.println(dog1 == dog2);
        System.out.println(dog1.equals(dog2));

        long i1 = 0xf;
        long i2 = 010;
        System.out.println("i1 = " + Long.toBinaryString(i1));
        System.out.println("i2 = " + Long.toBinaryString(i2));
        float f4 = Float.MAX_EXPONENT;
        float f5 = Float.MIN_EXPONENT;
        double d1 = Double.MAX_EXPONENT;
        System.out.println(f4);
        System.out.println(f5);
    }
}

class Dog{
    String name;
    String says;

    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }
}
