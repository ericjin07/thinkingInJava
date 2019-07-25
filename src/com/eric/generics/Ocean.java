package com.eric.generics;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/12/2019 3:48 PM
 */

class BigFish {
    private static int count = 0;
    private final int id = count++;

    @Override
    public String toString() {
        return "BigFish " + id;
    }

    public static Generator<BigFish> generator() {
        return BigFish::new;
    }

    private BigFish() {
    }
}

class LittleFish {
    private static int count = 0;
    private final int id = count++;
    private LittleFish(){}
    public static Generator<LittleFish> generator(){
        return LittleFish::new;
    }

    @Override
    public String toString() {
        return "LittleFish " + id ;
    }
}

public class Ocean {

    private static Random rand = ThreadLocalRandom.current();

    public static void eat(BigFish bf, LittleFish lf) {
        System.out.println(bf + " eats " + lf);
    }

    public static void main(String[] args) {
        Queue<LittleFish> littleFish = new LinkedList<>();
        Generators.fill(littleFish, LittleFish.generator(), 15);

        List<BigFish> bigFish = new ArrayList<>();
        Generators.fill(bigFish, BigFish.generator(), 3);

        for (LittleFish lf : littleFish) {
            eat(bigFish.get(rand.nextInt(bigFish.size())), lf);
        }
    }
}
