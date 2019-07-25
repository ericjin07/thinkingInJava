package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/18/2019 9:58 PM
 */
class Generic1<T> {
    T t;
    void take(T t) {
        this.t = t;
    }
}

class Generic2<T> {
    T t;

    T give() {
        return t;
    }
}
public class Ex28 {

    //generic1 consume the t, so it's super
    <T> void cotra(Generic1<? super T> generic1, T t) {
        generic1.take(t);
    }

    //generic2 produce the t, so it't extends
    <T> T co(Generic2<? extends T> generic2) {
        return generic2.give();
    }
}
