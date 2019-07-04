package com.eric.functional;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/15/2019 3:48 PM
 */
class X {
    String f() {
        return "X:FF";
    }
}

interface MakeString {
    String make();
}

interface TransferX {
    String transfer(X x);
}
public class UnboundMethodReference {

    public static void main(String[] args) {
//        MakeString m = X::f;
        TransferX tx = X::f;
        System.out.println(tx.transfer(new X()));
        System.out.println(new X().f());
    }
}
