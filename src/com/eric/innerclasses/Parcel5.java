package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 10:04 PM
 */
class Destination{
    String lable;
    public String readlable(){return lable;}
}

public class Parcel5 {
    public Destination destination(String s){
        class PDestination extends Destination{

            private PDestination(String lable) {
                this.lable = lable;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("fsdou");
        System.out.println(d.readlable());
    }
}
