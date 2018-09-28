package com.eric.interfaces;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/20/2018 10:34 PM
 */
public interface FactoryEx18 {
    CycleEx18 getCycle();
}

class UnicycleFatory implements FactoryEx18{

    @Override
    public CycleEx18 getCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements FactoryEx18 {
    @Override
    public CycleEx18 getCycle() {
        return new Bycycle();
    }
}

class TricycleFctory implements FactoryEx18 {
    @Override
    public CycleEx18 getCycle() {
        return new Tricycle();
    }
}
