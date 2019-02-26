package com.eric.holding;

import java.util.HashMap;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/21/2019 4:17 PM
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        char a = 'a';
        String alp;
        for (int i = 0; i < 20; i++) {
            alp = (a++) + "";
            map.put(alp,String.valueOf(i));
        }
    }
}
