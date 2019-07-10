package com.eric.generics;


/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/10/2019 5:08 PM
 */
public class BasicGeneratorDemo {

    public static void main(String[] args) {
//        Generator<CounterObj> gen = new BasicGenerator_14<>(CounterObj.class);
        Generator<CounterObj> gen = BasicGenerator_14.create(CounterObj.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(gen.next());
        }
    }
}
