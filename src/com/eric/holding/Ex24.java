package com.eric.holding;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/12/2018 10:29 PM
 */
public class Ex24 {

    public static void main(String[] args) {
        Map<String,Gerbil> gerbils = new LinkedHashMap<>();
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
        SortedSet<String> sortedKey = new TreeSet<>(gerbils.keySet());
        Iterator<String> itr = sortedKey.iterator();

        Map<String,Gerbil> gtemp = new LinkedHashMap<>();
        while (itr.hasNext()) {
            String k = itr.next();
            gtemp.put(k,gerbils.get(k));
            gerbils.remove(k);
        }

        gerbils.putAll(gtemp);
        System.out.println(gtemp);
        System.out.println(gerbils);
    }
}
