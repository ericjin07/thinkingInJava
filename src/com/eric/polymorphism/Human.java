package com.eric.polymorphism;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/15/2018 5:56 PM
 */
public class Human extends Animal {

    @Override
    public void eat(){
        System.out.println("Human eating");
    }

    public static void main(String[] args) {
        Animal a = new Human();
        a.action();
    }
}
