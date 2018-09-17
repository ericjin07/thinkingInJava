package com.eric.interfaces;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/17/2018 4:47 PM
 */
public abstract class AbstractTest4 {

    abstract  void addRef(AbstractTest4 test4);
}

class DeriveClass4 extends AbstractTest4{

    void print(){
        System.out.println("print DeriveClass 4");
    }

     void addRef(AbstractTest4 test4){
//        test4.print();
    }

    public static void main(String[] args) {

    }
}