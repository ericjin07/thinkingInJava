package com.eric.IO;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/13/2019 1:28 PM
 */
public class Singleton implements Serializable {
    private static Singleton singleton;
    private String id;

    private Singleton(){id = "test";}

    public static Singleton getInstance(){
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public String getId() {
        return id;
    }

    private Object readResolve() throws ObjectStreamException {
        return singleton;
    }
}
