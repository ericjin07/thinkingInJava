package com.eric.enumerated;

import net.mindview.util.Generator;

import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 2:51 PM
 */
enum Cartoon {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private static Random rand = new Random(39);

    public static Cartoon  next() {
        return values()[rand.nextInt(values().length)];
    }}

public class EnumInplementation {

//    public static <T> void printNext(Generator<T> generator) {
//        System.out.println(generator.next());
//    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.println((Cartoon.next()));
    }
}
