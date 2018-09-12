package com.eric.operators;

import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/15/2018 21:23
 */
public class Exercise2 {

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();

        car1.weight = 12.3f;
        car2.weight = 45.6f;
        System.out.println("car1.weight: " + car1.weight + " car2.weight: " + car2.weight);
        car1 = car2;
        System.out.println("car1.weight: " + car1.weight + " car2.weight: " + car2.weight);
        car1.weight = 999.f;
        System.out.println("car1.weight: " + car1.weight + " car2.weight: " + car2.weight);
        foo(car2);
        System.out.println("car1.weight: " + car1.weight + " car2.weight: " + car2.weight);
        Random rand = new Random(47);
        System.out.println(rand.nextInt(100));
        System.out.println(exercise3(rand.nextDouble(),rand.nextInt()));

    }

    static void foo(Car foo){
        foo.weight = 123456789.987f;
    }

    static double exercise3(double distance, int seconde){
        return distance/seconde;
    }
}

class Car{
    float weight;
}
