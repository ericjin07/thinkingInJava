package com.eric.control;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 08/28/2018 17:35
 */
public class ListCharacters {

    public static void main(String[] args) {
        for (char c = 0; c < 128; c++)
            if (Character.isLowerCase(c))
                System.out.println("value: " + (int)c + " Character: " + c);
    }
}
