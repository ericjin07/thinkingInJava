package com.eric.functional;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/15/2019 3:54 PM
 */
class This {
    void two(int i, double d){}
    void three(int i, double d, String s){}
    void four(int i, double d, String s, char c){}
}
interface TwoArgs {
    void call2(This ts, int i, double d);
}

interface ThreeArgs {
    void call3(This ts, int i, double d, String s);
}

interface FourArgs {
    void call4(This ts, int i, double d, String s, char c);
}
public class MultiUnbound {

    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;
        This is = new This();
        twoArgs.call2(is,12,12.3);
        threeArgs.call3(is,12,12.3,"fasd");
        fourArgs.call4(is,12,32.43,"fasd",'d');
    }
}
