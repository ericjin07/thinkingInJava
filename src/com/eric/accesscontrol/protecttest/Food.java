package com.eric.accesscontrol.protecttest;

import java.sql.SQLOutput;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/07/2018 10:56 AM
 */
public class Food {
    protected String taste;
    private String pri;
    String friendly;
    public String pb;

    public Food(String taste) {
        this.taste = taste;
    }

    protected void whatTaste(){
        System.out.println(taste);
    }
}

class FoodTest{
    void foo(){
        new Food("fs").taste = 1231+"";
    }
}

