package com.eric.typeinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/14/2019 9:48 PM
 */
class Part {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<>();
    static {
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    private static Random rand = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part{}

class FuelFilter extends Filter {
     public static class Factory implements com.eric.typeinfo.Factory<FuelFilter>{
         @Override
         public FuelFilter create() {
             return new FuelFilter();
         }
     }
}

class AirFilter extends Filter {
    public static class Factory implements com.eric.typeinfo.Factory<AirFilter>{
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements com.eric.typeinfo.Factory<OilFilter>{
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part{}

class FanBelt extends Belt {
    public static class Factory implements com.eric.typeinfo.Factory<FanBelt>{
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements com.eric.typeinfo.Factory<GeneratorBelt>{
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

public class RegisteredFactory {

    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
