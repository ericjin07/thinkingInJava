package com.eric.enumerated;

import java.util.EnumMap;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 4:17 PM
 */
interface Command {
    void action();
}
public class EnumMaps {

    public static void main(String[] args) {
        EnumMap<OzWitch,Command> map = new EnumMap<>(OzWitch.class);
        map.put(OzWitch.EAST, ()->System.out.println("turn East"));
        map.put(OzWitch.SOUTH,()-> System.out.println("turn South"));
        for (Map.Entry<OzWitch,Command> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().action();
        }
    }
}
