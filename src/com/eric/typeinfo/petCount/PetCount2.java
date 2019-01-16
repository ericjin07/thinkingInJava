package com.eric.typeinfo.petCount;

import net.mindview.util.MapData;
import typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/10/2019 10:44 PM
 */
public class PetCount2 {

    static class PetCounter extends HashMap<Class<? extends Pet>,Integer> {

        public PetCounter() {
            super(MapData.map(LiteralPetCreator.allTypes,0));
        }

        public void count(Pet type) {
            for (Map.Entry<Class<? extends Pet>,Integer> pair : entrySet()) {
                if (pair.getKey().isInstance(type))
                    put(pair.getKey(),pair.getValue() + 1);
            }

        }

        public String toString() {
            StringBuilder result = new StringBuilder("{");
            for (Map.Entry<Class<? extends Pet>,Integer> pair : entrySet()) {
                result.append(pair.getKey().getSimpleName())
                        .append("=")
                        .append(pair.getValue())
                        .append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append("}");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : new LiteralPetCreator().createArray(20)) {
            petCounter.count(pet);
            System.out.print(pet.getClass().getSimpleName() + " ");
        }
        System.out.println();
        System.out.println(petCounter);
    }

}
