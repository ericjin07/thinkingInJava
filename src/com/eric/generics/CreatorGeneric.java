package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 1:38 PM
 */
abstract class GenericWithCreator<T> {
    T element;

    public GenericWithCreator() {
        element = creator();
    }

    protected abstract T creator();
}

class X {}

class XCreator extends GenericWithCreator<X> {
    @Override
    protected X creator() {
        return new X();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {

    public static void main(String[] args) {
        XCreator gwc = new XCreator();
        gwc.f();
    }
}
