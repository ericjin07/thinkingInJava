package com.eric.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/25/2019 8:41 PM
 */
public class Ex29 {

    public static void main(String[] args) {

    }

    public static void get(Holder<List<?>> holder) {
        holder.setValue(new ArrayList<>());
        List list = holder.getValue();
    }
}

