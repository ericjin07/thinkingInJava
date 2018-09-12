package com.eric.reuseclass;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/11/2018 5:16 PM
 */
class Component1 {
    Component1(byte b) { System.out.println("Component1(byte)"); }
    void dispose(){
        System.out.println("Component1.dispose");
    }
}

class Component2 {
    Component2(short s) { System.out.println("Component2(short)"); }
    void dispose(){
        System.out.println("Component2.dispose");
    }
}

class Component3 {
    Component3(int i) { System.out.println("Component3(int)"); }
    void dispose(){
        System.out.println("Component3.dispose");
    }
}

public class Root {
    Component1 c1root;
    Component2 c2root;
    Component3 c3root;
    Root(float f) {
        c1root = new Component1((byte)0);
        c2root = new Component2((short)0);
        c3root = new Component3(0);
        System.out.println("Root(foat)");
    }
    void dispose(){
        c1root.dispose();
        c2root.dispose();
        c3root.dispose();
        System.out.println("root.dispose");
    }
}

class Stem10 extends Root {
    Component1 c1stem10;
    Component2 c2stem10;
    Component3 c3stem10;
    Stem10(double d) {
        super(2.78f);
        c1stem10 = new Component1((byte)1);
        c2stem10 = new Component2((short)1);
        c3stem10 = new Component3(1);
        System.out.println("Stem10(double)");
    }
    @Override
    void dispose(){
        c1stem10.dispose();
        c2stem10.dispose();
        c3stem10.dispose();
        super.dispose();
        System.out.println("stem10.dispose");
    }

    public static void main(String[] args) {
        Stem10 x = null;
        try{ x = new Stem10(2.78);}finally {
           x.dispose();
       }
    }
}
