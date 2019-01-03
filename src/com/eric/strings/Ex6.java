package com.eric.strings;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/02/2019 6:24 PM
 */
public class Ex6 {

    private int i;
    private long l;
    private float f;
    private double d ;

    public Ex6() {
        this.i = 10;
        this.l = 19L;
        this.f = 10.43f;
        this.d = 102.32;
    }

    public static void main(String[] args) {
        Ex6 e  = new Ex6();
        System.out.println(e);
    }

    @Override
    public String toString() {
        return String.format("Ex6: {%-5d %5d %8.2f %8.2f}",i,l,f,d);
    }
}
