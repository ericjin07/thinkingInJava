package com.eric.holding;

import typeinfo.pets.Pet;

import java.util.Collection;
import java.util.Iterator;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/17/2018 5:08 PM
 */
public class InterfaceVsIterator {

    public static void display(Iterator<Pet> itr) {
        while (itr.hasNext()) {
            Pet p = itr.next();
            System.out.print(p.id() + "  : " + p + "  ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> c) {
        for(Pet p : c) {
            System.out.print(p.id() + "  : " + p + "  ");
        }
        System.out.println();
    }
}
