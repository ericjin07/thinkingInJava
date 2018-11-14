package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 5:09 PM
 */
public class Parcel10 {
    public Destination getDestination(final float price,final String dest){
        return new Destination(){
            private int cost;
            {       //instance initializer
                cost = Math.round(price);
                System.out.println(cost + " cost");
                if (cost > 100)
                    System.out.println("out of budget");
            }
            String lable = dest;
            public String readlable(){return lable;}
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.getDestination(120.23f,"Hongkong");
        System.out.println(d.readlable());
    }
}
