package com.eric.typeinfo.petCount;

import typeinfo.pets.*;

import java.util.HashMap;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/10/2019 10:29 PM
 */
public class PetCount {

    static class PetCounter extends HashMap<String,Integer> {

        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type,1);
            else
                put(type, quantity + 1);
        }
    }

    public static void countPet (PetCreator creator) {
        Pet[] pets = creator.createArray(20);
        PetCounter counter = new PetCounter();
        for (Pet p : pets) {
            System.out.print(p.getClass().getSimpleName() + " ");
            if (p instanceof Pet)
                counter.count("Pet");
            if (p instanceof Dog)
                counter.count("Dog");
            if (p instanceof Cymric)
                counter.count("Cymric");
            if (p instanceof EgyptianMau)
                counter.count("EgyptianMau");
            if (p instanceof Hamster)
                counter.count("Hamster");
            if (p instanceof Manx)
                counter.count("Manx");
            if (p instanceof Mutt)
                counter.count("Mutt");
            if (p instanceof Rodent)
                counter.count("Rodent");
        }
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPet(new ForNameCreator());
        countPet(new LiteralPetCreator());
        System.out.println();
    }
}
