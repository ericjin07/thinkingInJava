package com.eric.accesscontrol.otherfood;

import com.eric.accesscontrol.protecttest.Food;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/07/2018 10:58 AM
 */
public class Apple extends Food {

    public Apple(String taste) {
        super(taste);
    }

    public static void main(String[] args) {
        Apple apple = new Apple("good");
        apple.whatTaste();
    }
}

class Orange{

}
