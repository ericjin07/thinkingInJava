package com.eric.functional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/16/2019 4:59 PM
 */
public class TriFunctionTest {

    static boolean test(int i, long l, double d) {
        return i + l + d > 20;
    }

    public static void main(String[] args) {
        TriFunction<Integer,Long, Double, Boolean> tf = TriFunctionTest::test;
//        tf = (i,l,d) -> false;
        System.out.println(tf.apply(1231,12L,312.3));
        Stream.of("one", "two", "three", "four")
//                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(System.out::println);
    }
}
