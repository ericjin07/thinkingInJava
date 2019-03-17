package com.eric.enumerated;

import com.eric.interfaces.NestInterface;

import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 2:57 PM
 */
public class Enums {

    private static Random rand = new Random(48);

    public static <T extends Enum<T>> T rand(Class<T> c){
        return rand(c.getEnumConstants());
    }

    public static <T> T rand(T[] ec) {
        return ec[rand.nextInt(ec.length)];
    }

}
