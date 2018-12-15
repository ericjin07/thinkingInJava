package com.eric.holding;

import java.util.ArrayList;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/27/2018 7:21 PM
 */
public class Gerbil {
    private int gerbilNumber;
    private String name;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public Gerbil(String name) {
        this.name = name;
    }

    public void hop(){
        System.out.println("which gerbil  " + name + " is hop");
    }

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            gerbils.add(new Gerbil(i));
        }
        for (int i = 0; i < gerbils.size(); i++)
            gerbils.get(i).hop();

    }
}
