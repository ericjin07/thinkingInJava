package com.eric.typeinfo.petCount;

import typeinfo.pets.Pet;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/10/2019 10:10 PM
 */
public abstract class PetCreator {

    public abstract List<Class<? extends Pet>> type();
    private Random rand = new Random(47);

    public Pet randomPet() {
        int i = rand.nextInt(type().size());
        try {
            return type().get(i).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; i++) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public List<Pet> createList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result,createArray(size));
        return result;
    }
}
