package com.eric.annotation;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/15/2019 11:10 AM
 */
public class UserCaseTracker {

    public static void trackUserCase(List<Integer> userCases,Class<?> cl){
        for (Method m:cl.getDeclaredMethods()){
            UserCase uc = m.getAnnotation(UserCase.class);
            if (uc != null){
                System.out.println("Found Use Case:" + uc.id() +
                        " " + uc.description());
                userCases.remove(new Integer(uc.id()));
            }
        }
        for (int i:userCases){
            System.out.println("Warning: Missing use case-" + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> us = new ArrayList<>(Arrays.asList(47,48,49,40));
        trackUserCase(us,PasswordUtils.class);
    }
}
