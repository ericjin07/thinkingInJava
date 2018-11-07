package com.eric.innerclasses;

import com.eric.object.Exs6Base;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 9:41 PM
 */
public class Ex6 extends Exs6Base {

    public Exs6BaseInner getInner(){
        return this.new Exs6BaseInner();
    }

    public static void main(String[] args) {
        Ex6 ex6 = new Ex6();
        ex6.getInner().say();
    }
}
