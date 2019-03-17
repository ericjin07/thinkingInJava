package com.eric.enumerated;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 3:02 PM
 */
enum Activity { SITTING, LYING, STANDING, HOPPING,
    RUNNING, DODGING, JUMPING, FALLING, FLYING }

public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            System.out.print(Enums.rand(Activity.class) + " ");
    }
}
