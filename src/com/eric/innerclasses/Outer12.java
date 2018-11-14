package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 9:48 PM
 */
public class Outer12 {
    private String name;
    private void show(){
        System.out.println(name);
    }

    private void hai(){
        System.out.println("hai" );
    }

    public Inner modify(){
        return new Inner(){

            @Override
            void modify() {
                name += "inner class change";
                hai();
            }
        };

    }

    public static void main(String[] args) {
        Outer12 outer7 = new Outer12();
        outer7.show();
        outer7.modify().modify();
        outer7.show();
    }
}

abstract class Inner{
    String in;
    abstract void modify();
}