package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 4:40 PM
 */
public class Parcel8 {

    public Wrapping wrapping(int x){
        return new Wrapping(x){
            public int value(){
                return super.value() * 31;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 parcel8 = new Parcel8();
        Wrapping wrapping = parcel8.wrapping(8);
        System.out.println(wrapping.value());
        System.out.println(wrapping.val);
    }
}

class Wrapping{
    int val;

    public Wrapping(int val) {
        this.val = val;
    }
    public int value(){
        return val;
    }
}
