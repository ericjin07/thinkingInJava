package com.eric.holding;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/27/2018 7:21 PM
 */
public class Gerbil_ex8 {
    private int gerbilNumber;

    public Gerbil_ex8(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public void hop(){
        System.out.println("which gerbil_ex8  " + gerbilNumber + " is hop");
    }

    public static void main(String[] args) {
        ArrayList<Gerbil_ex8> gerbils = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            gerbils.add(new Gerbil_ex8(i));
        }
        Iterator itr = gerbils.iterator();
        while (itr.hasNext())
            ((Gerbil_ex8)itr.next()).hop();

    }
}
