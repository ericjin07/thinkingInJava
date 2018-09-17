package com.eric.polymorphism;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/16/2018 1:09 PM
 */
public class Sandwich extends PortableLunch{
    private static PortableLunch portableLunch= new PortableLunch();

    public Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }
}

class Meal{
    public Meal() {
        System.out.println("Meal()");
    }
}

class Bread{
    public Bread() {
        System.out.println("Bread()");
    }
}

class Cheese{
    public Cheese() {
        System.out.println("Cheese()");
    }
}

class Lunch extends Meal{
    public Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch{
    public PortableLunch() {
        System.out.println("PortableLunch()");
    }
}
