package com.eric.polymorphism;

import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/16/2018 8:22 PM
 */
public abstract class Rodent {
    private Characteristic c = new Characteristic("has tail");
    private Description d = new Description("small mammal");
    public abstract void eat();

    private Share share;
    private static long count;
    private final long id = count++;

    public Rodent(Share share) {
        this.share = share;
        this.share.addRef();
        System.out.println("create" + this);
    }

    @Override
    public String toString() {
        return "Rodent{" +
                "id=" + id +
                '}';
    }

    public static void main(String[] args) {

        Rodent[] rodents = new Rodent[5];
        for (Rodent r: rodents){
            r = RodenGenerator.rodentsFactory();
            r.eat();
        }
        RodenGenerator.share.finalize();
    }
}

class RodenGenerator{
    static Random random = new Random();
    public static Share share = new Share();
    public static Rodent rodentsFactory(){
        switch (random.nextInt(3)){
            default:
            case 0:
                return new Mouse(share);
            case 1:
                return new Gerbil(share);
            case 2:
                return new Hamster(share);
        }
    }

}

class Mouse extends Rodent{
    private Characteristic c = new Characteristic("likes cheese");
    private Description d = new Description("nocturnal");

    public Mouse(Share share) {
        super(share);
        System.out.println("Mouse()");
    }

    @Override
    public void eat() {
        System.out.println("eat Mouse");
    }
}

class Gerbil extends Rodent{
    private Characteristic c = new Characteristic("larger");
    private Description d = new Description("black");

    public Gerbil(Share share) {
        super(share);
        System.out.println("Gerbil");
    }

    @Override
    public void eat() {
        System.out.println("eat Gerbil");
    }
}

class Hamster extends Rodent{
    private Characteristic c = new Characteristic("climbs trees");
    private Description d = new Description("likes nuts");
    @Override
    public void eat() {
        System.out.println("eat Hamster");
    }

    public Hamster(Share share) {
        super(share);
        System.out.println("Hamster()");
    }
}

class Characteristic {
    private String s;
    Characteristic(String s) {
        this.s = s;
        System.out.println("Creating Characteristic " + s);
    }
}

class Description {
    private String s;
    Description(String s) {
        this.s = s;
        System.out.println("Creating Description " + s);
    }
}
