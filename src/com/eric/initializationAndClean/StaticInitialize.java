package com.eric.initializationAndClean;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/05/2018 10:44 AM
 */
public class StaticInitialize {

    public static void main(String[] args) {
        Dog.print();
    }

}

class Dog{
    static String str = "static field";
    static String str1;
    static {
        str1 = "static block";
    }

    public static void print(){
        System.out.println(str);
        System.out.println(str1);
    }
}
