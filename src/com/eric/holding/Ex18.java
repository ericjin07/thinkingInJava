package com.eric.holding;

import sun.java2d.pipe.SpanIterator;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 1:20 PM
 */
public class Ex18 {

    public static void main(String[] args) {
        Map<String,Gerbil> gerbils = new HashMap<>();
        gerbils.put("Caro",new Gerbil("Caro"));
        gerbils.put("Fuzze",new Gerbil("Fuzze"));
        gerbils.put("Allen",new Gerbil("Allen"));
        gerbils.put("Bully",new Gerbil("Bully"));
        gerbils.put("Dopey", new Gerbil("Dopey"));
        gerbils.put("Sleepy", new Gerbil("Sleepy"));
        gerbils.put("Happy", new Gerbil("Happy"));
        gerbils.put("Funny", new Gerbil("Funny"));
        gerbils.put("Silly", new Gerbil("Silly"));
        gerbils.put("Goofy", new Gerbil("Goofy"));
        gerbils.put("Wowee", new Gerbil("Wowee"));

        System.out.println(gerbils);
        Set<String> key = gerbils.keySet();
        SortedSet<String> sortedKey = new TreeSet<>(key);
        System.out.println(sortedKey);

        Map<String,Gerbil> sortedGerbils = new LinkedHashMap<>();
        for (String s : sortedKey)
            sortedGerbils.put(s,gerbils.get(s));
        System.out.println(sortedGerbils);

        //or just
        SortedMap<String,Gerbil> sortedMap = new TreeMap<>(gerbils);
        System.out.println(sortedMap);
    }
}
