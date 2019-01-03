package com.eric.strings;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/28/2018 5:27 PM
 */
public class Turtle {

    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d, %d)\n",name,x,y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        Turtle tommy = new Turtle("tommy",new Formatter(System.out));
        Turtle jerry = new Turtle("jerry",new Formatter(outAlias));
        tommy.move(0,0);
        jerry.move(2,3);
        tommy.move(2,4);
        jerry.move(9,0);
        tommy.move(6,9);
        jerry.move(1,3);
    }
}
