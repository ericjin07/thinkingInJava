package com.eric.typeinfo;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/18/2019 5:07 PM
 */
public class Person {
    private final String first;
    private final String last;
    private final String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public static class NullPerson extends Person implements Null {

        public NullPerson() {
            super("None", "None", "None");
        }
        public String toString() { return "NullPerson"; }
    }

    public static final Person Null = new NullPerson();

    public String toString() {
        return "Person: " + first + " " + last + " " + address;
    }
}
