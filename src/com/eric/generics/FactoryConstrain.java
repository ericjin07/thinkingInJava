package com.eric.generics;



/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 11:42 AM
 */
interface FactoryI<T> {
    T create();
}

class FactoryFactor<T> {

    private T x;

    public <F extends FactoryI<T>> FactoryFactor(F factory) {
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return 0;
    }
}

class Widget {

    static class Factory implements FactoryI<Widget> {
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
public class FactoryConstrain {

    public static void main(String[] args) {
        FactoryFactor<Integer> ffi = new FactoryFactor<>(new IntegerFactory());
        FactoryFactor<Widget> ffw = new FactoryFactor<>(new Widget.Factory());
    }
}
