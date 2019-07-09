package com.eric.generics;

import typeinfo.pets.Pet;
import typeinfo.pets.Pug;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/23/2019 10:08 PM
 */
public class Holder3<T> {
    private T t;
    public Holder3(T t) {
        this.t = t;
    }

    public T get(){return t;}
    public void set(T t){this.t = t;}


    public static void main(String[] args) {
        Holder3<Pet> holder3 = new Holder3<>(new Pug("pug"));
        System.out.println(holder3.get());


        Map<String,String> map = new HashMap<String, String>();
        map.put("c","cc");
        map.put("a","aa");
        map.put("r","rr");
        map.put("d","dd");
        System.out.println(map);

        TreeMap<String,String> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);

        double arr[][] = new double[3][4];
        for (int i = 0; i < arr.length;i++) {
            for (int j = 0; j < arr[i].length;j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }

//        Set<?> set = new HashSet<>();
//        set.add("string");        //can't put

//        Object[] objects = new Long[1];
//        objects[0] = "hah";     //runtime ArrayStoreException

//        List<Object> objects = new ArrayList<Long>();   //compile time incompatible
    }
}
