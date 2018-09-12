package com.eric.reuseclass;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/12/2018 2:48 PM
 */
public class Insect {

    int i = print("initalize the insect filed");

    static {
        System.out.println("loading Insect.Class");
    }

    int print(String s){
        System.out.println(s);
        return 99;
    }
}

class Beetle extends Insect{

    int v = print("initalize the Beetle Filed");

    static {
        System.out.println("loading Beetle.Class");
    }

    public static void main(String[] args) {
        new Beetle();
    }

}
