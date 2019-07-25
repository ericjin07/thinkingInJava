package com.eric.generics;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/12/2019 5:45 PM
 */
class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T> {
    private T t;

    public Manipulator(T t) {
        this.t = t;
    }
    public void manipulate() {
//        t.f();    //won't compiler
    }
}

class Manipulator_2<TT extends HasF> {
    private TT t;

    public Manipulator_2(TT t) {
        this.t = t;
    }
    public void manipulate() {
        t.f();    //won't compiler
    }
}

public class Manipulation {

    public static void main(String[] args) {
        HasF hasF = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        Manipulator_2<HasF> manipulator_2 = new Manipulator_2<>(hasF);
        manipulator.manipulate();
        manipulator_2.manipulate();
        System.out.println(Arrays.toString(manipulator_2.getClass().getTypeParameters()));
    }
}
