package com.eric.accesscontrol.classaccess;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/08/2018 12:03 PM
 */
public class Lunch {

    public static void main(String[] args) {
        Soup soup =Soup.getSoup();
        Soup2 soup2 =Soup2.getSoup();
    }
}

class Soup {
    public static int count ;

    private Soup() {
        System.out.println("Soup");
    }
    static Soup getSoup(){return new Soup();}
}

class Soup2 {
    private Soup2(){
        System.out.println("Soup2");
    }
    public static Soup2 getSoup(){return new Soup2();}
}
