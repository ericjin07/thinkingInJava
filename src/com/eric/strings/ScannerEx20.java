package com.eric.strings;

import java.util.Scanner;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/04/2019 10:42 AM
 */
public class ScannerEx20 {
    private int i;
    private double d;
    private long l;
    private float f;
    private String s;

    public ScannerEx20(String s) {
        Scanner scanner = new Scanner(s);
        scanner.useDelimiter("\\s*,\\s*");
        i = scanner.nextInt();
        d = scanner.nextDouble();
        l = scanner.nextLong();
        f = scanner.nextFloat();
        this.s = s;
    }

    public static void main(String[] args) {
        ScannerEx20 se = new ScannerEx20("12, 32.3, 12331231, 33.32");
        System.out.println(se);
    }

    @Override
    public String toString() {
        return "ScannerEx20{" +
                "i=" + i +
                ", d=" + d +
                ", l=" + l +
                ", f=" + f +
                ", s='" + s + '\'' +
                '}';
    }
}
