package com.eric.generics;

import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/16/2019 7:55 PM
 */
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple {
}

class Orange extends Fruit{}

public class CovarianArrays {

    public static void main(String[] args) {
        Fruit fruit[] = new Apple[10];
        fruit[0] = new Apple();
        fruit[1] = new Jonathan();
        try {
        fruit[2] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruit[3] = new Orange();
        }catch (Exception e) {
            System.out.println(e);
        }

        Number number[] = new Integer[10];
        number[0] = 1;
        System.out.println(Arrays.toString(number));
//        number[1] = new Double(12);   //run time
//        Integer[] ints = number;  //won't compiler
    }
}
