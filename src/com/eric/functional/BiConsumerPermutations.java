package com.eric.functional;

import java.util.function.BiConsumer;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/16/2019 5:27 PM
 */
public class BiConsumerPermutations {
    static BiConsumer<Long,Integer> bicli = (l,i) -> System.out.printf("%d, %d\n",l,i);
    static BiConsumer<Double,Integer> bicdi = (d,i) -> System.out.printf("%f, %d\n",d,i);
    static BiConsumer<Long,Double> bicld = (l,d) -> System.out.printf("%d, %f\n",l,d);
    
    public static void main(String[] args) {
        bicli.accept(32L,312);
        bicdi.accept(12.3,12);
        bicld.accept(12L,22.3);
    }
}
