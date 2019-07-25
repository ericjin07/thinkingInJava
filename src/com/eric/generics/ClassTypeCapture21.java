package com.eric.generics;

import java.util.HashMap;
import java.util.Map;


/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 10:58 AM
 */
class Building {

    static class Factory implements FactoryI<Building> {
        @Override
        public Building create() {
            return new Building();
        }
    }
}

class House extends  Building {
    private String location;
    private Integer area;

    public House() {
        location = null;
    }

    public House(Integer area) {
        this.area = area;
        location = null;
    }

    public House(String location) {
        this.location = location;
    }

    public House(String location, Integer area) {
        this.location = location;
        this.area = area;
    }

    static class Factory implements FactoryI<House> {
        @Override
        public House create() {
            return new House();
        }
    }

    @Override
    public String toString() {
        return "House{" +
                "location='" + location + '\'' +
                ", area=" + area +
                '}';
    }
}

public class ClassTypeCapture21<T> {
    private Class<?> kind;
    private Map<String, Class<?>> map = new HashMap<>();

    public ClassTypeCapture21(Class<?> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture21(Class<?> kind, Map<String, Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    public void addType(String typename, Class<?> kind) {
        map.put(typename, kind);
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public Object createNew(String typename, Object ... args) {
        if (map.containsKey(typename)) {
            Class<?> kind = map.get(typename);
            try {
                switch (args.length) {
                    case 0:
                        return kind.newInstance();
                    case 1:
                        return kind.getConstructor(args[0].getClass()).newInstance(args[0]);
                    case 2:
                        return kind.getConstructor(args[0].getClass(), args[1].getClass()).newInstance(args[0],args[1]);
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture21<Building> ctt1 = new ClassTypeCapture21<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture21<House> ctt2 = new ClassTypeCapture21<>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));

        ClassTypeCapture21<Building> ct = new ClassTypeCapture21<>(Building.class, new HashMap<>());
        ct.addType("house", House.class);
        ct.addType("building", Building.class);

        Building b = (Building) ct.createNew("building");
        House h = (House) ct.createNew("house");
        System.out.println("b.getClass().getSimpleName():" + b.getClass().getSimpleName());
        System.out.println("h.getClass().getSimpleName():" + h.getClass().getSimpleName());

        System.out.println("House h is instance House: " + ct.f(h));
        System.out.println("building b is instance House: " + ct.f(b));

        House heyingx = (House) ct.createNew("house", "Heyingxuan");
        System.out.println("heyingx : " + heyingx);

        House baoli = (House) ct.createNew("house", "Baoli", 40);
        System.out.println("baoli : " + baoli);

        ct.createNew("String");
    }
}
