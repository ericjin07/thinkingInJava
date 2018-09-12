package com.eric.reuseclass;

import java.util.Random;
import java.util.Stack;
import java.util.Vector;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/12/2018 9:59 AM
 */
public class OverLoadTest extends Father{

    final Father father;

    public OverLoadTest() {
        father = new Father();
        System.out.println("new father");
    }

    void foo(boolean b){
        System.out.println("foo4 " + b + " boolean");
    }

//    @Override
//    void foo(){
//        System.out.println("foo2 " + a + " int static " + VAL);
//    }

    private void foo(double d){
        System.out.println("foo3 " + d + " double");
    }

    public static void main(String[] args) {
        OverLoadTest test = new OverLoadTest();
        OverLoadTest test2 = new OverLoadTest();
        test.tell(test);
        test.tell((Father) test);
        test.foo(true);
        test.foo(1);
        test.foo(13.4);
        test.foo();
        System.out.println("---------------");
        test2.tell(test2);
        test2.tell((Father) test2);
        test2.foo(true);
        test2.foo(1);
        test2.foo(13.4);
        test2.foo();
        System.out.println("---------------");
        Son son = new Son();
        son.a = 12;
//        son.b = 343242;
        son = new Son();
    }
}

class Father{

    private static Random random = new Random();
    final int i = random.nextInt(34);
    static final int VAL = random.nextInt(34);

    final void foo(){

        System.out.println("foo1 filed" + i);
    }

    private void foo(int a){
        System.out.println("foo2 " + a + " int static " + VAL);
    }

    private void foo(double d){
        System.out.println("foo3 " + d + " double");
    }

    void tell(Father father){
        System.out.println("father");
    }

    void tell(OverLoadTest overLoadTest){
        System.out.println("overLoadTest");
    }
}

final class Son{
    int a = 5;
    final int b;

    public Son() {
        b = 98;
    }
}
