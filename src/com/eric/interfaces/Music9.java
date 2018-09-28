package com.eric.interfaces;

import com.eric.Note;

import static com.eric.Main.print;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/17/2018 5:54 PM
 */
abstract class Instrument {
    private int i;
    public String toString() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument implements Playable{
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Wind"; }
    public void adjust() { print(this + ".adjust()"); }
}

class Percussion extends Instrument implements Playable{
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Percussion"; }
    public void adjust() { print(this + ".adjust()"); }
}

class Stringed extends Instrument implements Playable{
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Stringed"; }
    public void adjust() { print(this + ".adjust()"); }
}

class Brass extends Wind {
    public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
    public String toString() { return "Woodwing"; }
}

public class Music9 {
    // Doesn't care about type, so new types
    // added to the system will work right:
    static void tune(Playable i) {
        //...
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Playable[] e) {
        for(Playable i : e)
            tune(i);
    }
    public static void main(String[] args) {
        // Upcasting during addition to the array:
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestra);
    }
}

interface Playable{
    void play(Note n);
}