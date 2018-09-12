package com.eric.reuseclass;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/11/2018 5:05 PM
 */
public class A {
    public A(int a) {
        System.out.println("aaaaa---" + a);
    }

    public static void main(String[] args) {
        C c = new C();
    }
}
class B extends A{
    public B(int a) {
        super(a);
        System.out.println("bbbbb---" + a);
    }
}

class C extends A{
    B b = new B(123);
    public C() {
        super(9898);
        System.out.println("ccccc");
    }
}

