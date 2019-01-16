package com.eric.typeinfo;

import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/09/2019 10:09 PM
 */
class Initalbe {
    static  int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(89);
    static {
        System.out.println("initable");
    }
}

public class ClassInitialization {

    static Random rand = new Random(46);

    public static void main(String[] args) {
        Class clz = Initalbe.class;
        System.out.println(Initalbe.staticFinal);
        System.out.println(Initalbe.staticFinal2);
        Class<Number> i = Number.class;
//        Class<Number> in = Integer.class;   can't be
        Class<? extends Number> in = Integer.class;
        System.out.println(i);
        System.out.println(in);
        in = double.class;
        System.out.println(in);
    }
}
