package com.eric.generics;

import com.eric.reuseclass.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/16/2019 7:58 PM
 */
public class GenericsAndCovariance {

    public static void main(String[] args) {
//        List<Fruit> fruits = new ArrayList<Apple>();      //won't compiler

        List<? extends Fruit> fruits = new ArrayList<>(Arrays.asList(new Apple()));
//        fruits.add(new Apple());  //can't add any type of Object
//        fruits.add(new Fruit());
//        fruits.add(new Orange());
//        fruits.add(null);
        fruits.contains(new Apple());
        fruits.indexOf(new Apple());
        System.out.println(fruits);
    }
}
