package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 9:15 PM
 */
public class DotThis {
    void f(){
        System.out.println("DotThis.f()");
    }
    public class Inner{
        DotThis out(){
            return DotThis.this;
        }
    }

    public Inner inner(){return new Inner();}
    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.inner();
        inner.out().f();
        DotThis.Inner inner1 = dotThis.new Inner();
        inner1.out().f();
    }
}
