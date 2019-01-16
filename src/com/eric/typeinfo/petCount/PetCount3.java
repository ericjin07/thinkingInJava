package com.eric.typeinfo.petCount;

import typeinfo.pets.Pet;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/10/2019 11:15 PM
 */
public class PetCount3 {

    public static void main(String[] args) {
        TypeCount typeCount = new TypeCount(Pet.class);
        for (Pet p : new LiteralPetCreator().createArray(30)){
            System.out.print(p.getClass().getSimpleName() + " ");
            typeCount.count(p);
        }

        for (Pet p : new LiteralPetCreator().createArray(30)){
            System.out.print(p.getClass().getSimpleName() + " ");
            typeCount.count(p);
        }
        System.out.println();
        System.out.println(typeCount);
    }
}
