package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 9:48 PM
 */
public class Outer7 {
    private String name;
    private void show(){
        System.out.println(name);
    }

    private void hai(){
        System.out.println("hai" );
    }

    class Inner{
        private String in;
        void modifyOutName(){
            name = name + " inner channge";
            hai();
        }
    }


    public void modify(){
        Inner inner = new Inner();
//        need to create an object to access the private field
        inner.in = "innnnnn";
        System.out.println(inner.in);
        inner.modifyOutName();
    }

    public static void main(String[] args) {
        Outer7 outer7 = new Outer7();
        outer7.show();
        outer7.modify();
        outer7.show();
    }
}
