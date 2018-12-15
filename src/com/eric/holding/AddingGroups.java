package com.eric.holding;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/27/2018 7:53 PM
 */
public class AddingGroups {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer more[] = {6,7,8,9};
        collection.addAll(Arrays.asList(more));
        Collections.addAll(collection,10,11,12,13);
        Collections.addAll(collection,more);
        System.out.println(collection);
        Map map = new HashMap();
        map.put("cat","fasd");
        map.put("dog","ffasdasd");
        System.out.println(map);
        List<Integer> list = Arrays.asList(26,27,28,22);        //Arrays.ArrayList extents AbstractList
        list.set(1,11);
        list.add(23);
    }
}
