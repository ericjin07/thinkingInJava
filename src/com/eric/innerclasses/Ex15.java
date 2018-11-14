package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 7:37 PM
 */
public class Ex15 {

    public Ex15Class getEx15Class(String h){
        return new Ex15Class(h){
            {
                System.out.println("Hello Inner Class");
            }
        };
    }

    public static void main(String[] args) {
        Ex15 ex15 = new Ex15();
        ex15.getEx15Class("helafsd");
    }
}

class Ex15Class{
    public Ex15Class() {
        System.out.println("default constructor");
    }

    public Ex15Class(String val){
        System.out.println("args constructor   " + val);
    }
}