package com.eric.interfaces.interfaceprocessor;


import static com.eric.Main.print;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/17/2018 8:39 PM
 */
public interface Processor {
    String name();
    Object process(Object o);
}

class Apply{
    public static void process(Processor p,Object s){
        print("Useing Processor " + p.name());
        print(p.process(s));
    }
}

