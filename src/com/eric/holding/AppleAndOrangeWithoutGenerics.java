package com.eric.holding;

import java.util.ArrayList;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/27/2018 7:05 PM
 */
class Apple{
    private static long counter = 0;
    private final long id = counter++;
    public long id(){return id;}
}

class Orange{}

public class AppleAndOrangeWithoutGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Apple> apple = new ArrayList();
        for (int i = 0; i < 5; i++)
            apple.add(new Apple());
//        apple.add(new Orange());
        for (int i = 0; i < apple.size(); i++)
            System.out.println(((Apple)apple.get(i)).id());
    }
}
