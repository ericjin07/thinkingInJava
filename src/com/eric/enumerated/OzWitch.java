package com.eric.enumerated;

import java.sql.SQLOutput;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 2:11 PM
 */
public enum  OzWitch {
    WEST("Miss Gulch, aka the Wicked Witch of the West"){
        @Override
        public void action() {
            System.out.println("west");
        }
    },
    NORTH("Glinda, the Good Witch of the North"){
        @Override
        public void action() {
            System.out.println("North");
        }
    },
    EAST("Wicked Witch of the East, wearer of the Ruby " +
            "Slippers, crushed by Dorothy’s house"){
        @Override
        public void action() {
            System.out.println("East");
        }
    },
    SOUTH("Good by inference, but missing"){
        @Override
        public void action() {
            System.out.println("South");
        }

        public String getDescription(){
            return "south--";
        }
    };
    private String desc;

    public abstract void action();
    public String getDescription() { return desc; }
    OzWitch(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : OzWitch.values()) {
//            System.out.println(ozWitch);
            ozWitch.action();
            System.out.println(ozWitch.getDescription());
        }
    }
}
