package com.eric.interfaces;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/20/2018 10:30 PM
 */
public interface CycleEx18 {
    void draw();
}

class Unicycle implements CycleEx18 {

    @Override
    public void draw() {
        System.out.println("draw Unicycle");
    }
}

class Bycycle implements CycleEx18 {
    @Override
    public void draw() {
        System.out.println("draw Bycycle");
    }
}

class Tricycle implements CycleEx18 {
    @Override
    public void draw() {
        System.out.println("Draw Tricycle");
    }
}
