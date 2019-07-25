package com.eric.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 1:59 PM
 */
public class ClassTypeCapture24 {
    private FactoryI<?> factoryI;
    private Map<String, FactoryI<?>> map = new HashMap<>();


    public ClassTypeCapture24(FactoryI<?> factoryI) {
        this.factoryI = factoryI;
        map.put(factoryI.getClass().getName(), factoryI);
    }

    public ClassTypeCapture24(FactoryI<?> factoryI, Map<String, FactoryI<?>> map) {
        this.factoryI = factoryI;
        this.map = map;
        map.put(factoryI.getClass().getName(), factoryI);
    }

    public void addType(String typename, FactoryI<?> factoryI) {
        map.put(typename, factoryI);
    }

    public Object createNew(String typename) {
        if (map.containsKey(typename)) {
            FactoryI<?> factoryI = map.get(typename);
            try {
                return factoryI.create();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture24 ctt1 = new ClassTypeCapture24(new Building.Factory());
        System.out.println(ctt1.createNew(Building.Factory.class.getName()));

        ctt1.addType(House.Factory.class.getName(), House::new);
        System.out.println(ctt1.createNew(House.Factory.class.getName()));

        ctt1.addType(Widget.Factory.class.getName(), Widget::new);
        System.out.println(ctt1.createNew(Widget.Factory.class.getName()));

        Object[] l = new Long[]{};
        System.out.println(l);
    }
}
