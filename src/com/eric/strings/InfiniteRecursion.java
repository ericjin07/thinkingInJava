package com.eric.strings;

import com.eric.exceptions.LostMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/27/2018 9:15 PM
 */
public class InfiniteRecursion {

    public String toString() {
        return " InfiniteRecursion  "+ super.toString() + '\n';
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);

        System.out.printf("Row 1 : [%d, %f]",12,23f);
        System.out.format("Row 1 : [%d, %f]",12,23f);
    }
}
