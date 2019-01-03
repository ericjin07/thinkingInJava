package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/26/2018 10:19 PM
 */
public class Ex25 {

    public static void main(String[] args) {
        Nomal_A ac = new Nomal_C();
        try {
            ac.meet();
        } catch (Exception_A exception_a) {
            exception_a.printStackTrace();
        }
    }
}

class Exception_A extends Exception{}
class Exception_B extends Exception_A{}
class Exception_C extends Exception_B{}

class Nomal_A {
    public void meet() throws Exception_A{}
}
class Nomal_B extends Nomal_A {
    public void meet() throws Exception_B{
        System.out.println("bbb");
    }
}
class Nomal_C extends Nomal_B {
    public void meet() throws Exception_C{
        System.out.println("ccc");
    }
}