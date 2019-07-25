package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/16/2019 7:27 PM
 */
interface AInf {
}


interface BInf {}

class Cclass implements AInf, BInf{

    @Override
    public String toString() {
        return "--=c==-";
    }
}

class D implements BInf {
    @Override
    public String toString() {
        return "--D==";
    }
}

public class Ex25 {

    public <T extends AInf & BInf> void f(T t) {
        System.out.println("fff" + t);
    }

    public <T extends BInf> void h(T t) {
        System.out.println("hhh" + t);
    }

    public static void main(String[] args) {
        Ex25 ex25 = new Ex25();
        ex25.f(new Cclass());
        ex25.h(new Cclass());
//        ex25.f(new D());  //compile error
        ex25.h(new D());
    }
}