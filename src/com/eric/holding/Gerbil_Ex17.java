package com.eric.holding;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 1:11 PM
 */
public class Gerbil_Ex17 {

    public static void main(String[] args) {
        Map<String,Gerbil> gerbils = new HashMap<>();
        gerbils.put("Fuzze",new Gerbil("Fuzze"));
        gerbils.put("Allen",new Gerbil("Allen"));
        gerbils.put("Bully",new Gerbil("Bully"));
        gerbils.put("Caro",new Gerbil("Caro"));

        Iterator<String> itr= gerbils.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next();
            System.out.println(key);
            gerbils.get(key).hop();
        }
    }
}
