package com.eric.reuseclass;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/11/2018 5:53 PM
 */
public class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        System.out.println(x);
    }
}

class DetergentDelegation {
    Cleanser c = new Cleanser();
    private String s = "DetergentDelegation";
    public void append(String a) {
        c.append(a);
    }

    public void dilute() {
        c.dilute();
    }

    public void apply() {
        c.apply();
    }

    public void scrub() {
        append("DetergentDelegation.scurb --");
        c.scrub();
    }
    public String toString() { return c + " " ; }
    public void foam() { append(" foam()"); }
    public static void main(String[] args) {
        DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        Cleanser.main(args);
    }
}
