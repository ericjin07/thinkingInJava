package com.eric.interfaces;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/20/2018 10:38 PM
 */
public class Cycles {

    public static void drawCycle(FactoryEx18 factory){
        factory.getCycle().draw();
    }

    public static void main(String[] args) {
        drawCycle(new BicycleFactory());
        drawCycle(new UnicycleFatory());
        drawCycle(new TricycleFctory());
    }
}
