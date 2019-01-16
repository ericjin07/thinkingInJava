package com.eric.typeinfo;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/08/2019 10:28 PM
 */
class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}
public class SweetShop7 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage of SweetShop");
            System.exit(0);
        }
        Class cs = null;
        Object obj = null;
        for (String n : args) {
            try {
                cs = Class.forName("com.eric.typeinfo." + n);
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found");
                System.exit(1);
            }
            try {
                obj = cs.newInstance();
                System.out.println(obj);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
