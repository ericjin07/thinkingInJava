package com.eric.interfaces;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/20/2018 9:56 PM
 */
public class NestInterface {
    interface A{
        void f();
        interface T{
            void f();
        }
    }

    private interface B{
        void f();
    }

    class Aimp implements A{
        @Override
        public void f() {

        }
    }
    class Bimp implements B{
        @Override
        public void f() {
            System.out.println("bimp .f()");
        }
    }

    public B getB(){
        return new Bimp();
    }

    public void receiveB(B b){
        b.f();
    }

    public static void main(String[] args) {
        NestInterface n = new NestInterface();
        B b = n.getB();
        b.f();
        n.receiveB(b);
    }
}
