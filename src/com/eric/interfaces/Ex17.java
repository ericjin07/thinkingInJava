package com.eric.interfaces;

import com.eric.Main;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/20/2018 8:43 PM
 */
public interface Ex17 {
    int x = Main.printInt(10);

}

class test17 implements Ex17{

    public static void main(String[] args) {
        test17 test = new test17();
        int a = test.x;
        int b = test.x;
        int c = test.x;
    }
}
