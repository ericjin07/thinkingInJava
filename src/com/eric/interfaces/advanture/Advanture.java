package com.eric.interfaces.advanture;


/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/18/2018 9:06 AM
 */
public class Advanture {

    public static void t(Fightable fightable){
        fightable.fight();
    }
    public static void u(Flyable flyable){
        flyable.fly();
    }
    public static void v(Swimable s){
        s.swim();
    }
    public static void w(ActionCharacter a){
        a.fight();
    }

    public static void c(Climbable c){
        c.climb();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
        c(hero);
    }
}

interface Fightable{
    void fight();
}

interface Swimable{
    void swim();
}

interface Flyable{
    void fly();
}

interface Climbable{
    void climb();
}

class ActionCharacter{
    public void fight(){
        System.out.println("can fightn");
    }
}

class Hero extends ActionCharacter implements Fightable, Swimable, Flyable, Climbable{
    @Override
    public void swim() {
        System.out.println("can swim");
    }

    @Override
    public void fly() {
        System.out.println("can fly");
    }

    @Override
    public void climb() {
        System.out.println("can climb");
    }
}