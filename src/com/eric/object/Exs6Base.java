package com.eric.object;

import com.eric.interfaces.Exs6;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 9:40 PM
 */
public class Exs6Base {
    protected class Exs6BaseInner implements Exs6 {

        public Exs6BaseInner() {
        }

        @Override
        public void say() {
            System.out.println("Exs6Base.Exs6BaseInner.say()");
        }
    }
}
