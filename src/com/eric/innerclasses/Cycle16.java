package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 7:59 PM
 */
public class Cycle16 {

    public static void drawCycle(CycleFactory factory){
        factory.getCycle().draw();
    }

    public static void main(String[] args) {
        drawCycle(Unicycle.factory);
        drawCycle(Bicycle.factory);
        drawCycle(Tricycle.factory);
    }
}

interface Cycle{
    void draw();
}

interface CycleFactory{
    Cycle getCycle();
}

class Unicycle implements Cycle{
    @Override
    public void draw() {
        System.out.println("Unicycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle{
    @Override
    public void draw() {
        System.out.println("Bicycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle{
    @Override
    public void draw() {
        System.out.println("Tricycle");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}