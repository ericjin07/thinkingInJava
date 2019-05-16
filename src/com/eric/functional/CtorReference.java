package com.eric.functional;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/15/2019 4:03 PM
 */
class Dog {
    int age = -1;
    String name;
    Dog() {
        name = "Gold Hair";
    }

    Dog(String name) {
        this.name = name;
    }

    Dog(String name, int age) {
        this(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

interface MakeDog1 {
    Dog arg0();
}

interface MakeDog2 {
    Dog arg1(String name);
}

interface MakeDog3 {
    Dog arg2(String name, int age);
}

public class CtorReference {

    public static void main(String[] args) {
        MakeDog1 dog1 = Dog::new;
        MakeDog2 dog2 = Dog::new;
        MakeDog3 dog3 = Dog::new;

        System.out.println(dog1.arg0());
        System.out.println(dog2.arg1("Henry"));
        System.out.println(dog3.arg2("here",12));
    }
}
