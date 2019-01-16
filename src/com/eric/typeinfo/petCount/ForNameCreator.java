package com.eric.typeinfo.petCount;

import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/10/2019 10:21 PM
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] typesName = new String[]{
      "typeinfo.pets.Cymric",
      "typeinfo.pets.Dog",
      "typeinfo.pets.EgyptianMau",
      "typeinfo.pets.Hamster",
      "typeinfo.pets.Manx",
      "typeinfo.pets.Mutt",
      "typeinfo.pets.Pug",
      "typeinfo.pets.Rat",
      "typeinfo.pets.Rodent",
    };

    static {
        loader();
    }

    @SuppressWarnings("unchecked")
    private static void loader() {
        for (String name : typesName) {
            try {
                types.add((Class<? extends Pet>) Class.forName(name));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Class<? extends Pet>> type() {
        return types;
    }
}
