package com.eric.functional;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/16/2019 4:17 PM
 */
@FunctionalInterface
interface Functional {
    void good(String s);
}

interface FunctionalNoAnn {
    void good(String s);
}

//@FunctionalInterface      can't compile
//interface FunctionalMult {
//    void good(String s);
//
//    void bye(String s);
//}

public class FunctionalAnnotation {

    private void good(String s) {
        System.out.println("good " +s);
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f1 = fa::good;
        FunctionalNoAnn fn = fa::good;
        f1.good("fsdfasd");
        fn.good("fsadfadsfadsf");
    }
}
