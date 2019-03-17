package com.eric.enumerated;

import com.sun.jmx.snmp.Enumerated;
import net.mindview.util.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

import static com.eric.enumerated.Signal.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 2:18 PM
 */
enum Signal {
    RED,GREEN,YELLO
}
public class TrafficLight {
    private Signal signal = RED;
    public void change() {
        switch (signal) {
            case RED:
                signal = GREEN;
                break;
            case GREEN:
                signal = YELLO;
                break;
            case YELLO:
                signal = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is "+signal;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 10; i++) {
            System.out.println(light);
            light.change();
        }

        analyze(RED.getClass());
        analyze(Enum.class);
//        OSExecute.command("javap com.eric.enumerated.Signal");


        Signal red = RED;
        Enum r = red;
        for (Enum e: r.getClass().getEnumConstants()){
            System.out.println(e);
        }
    }
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("----- Analyzing " + enumClass + " -----");
        System.out.println("Interfaces:");
for(Type t : enumClass.getGenericInterfaces())
    System.out.println(t);
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
    Set<String> methods = new TreeSet<String>();
for(Method m : enumClass.getMethods())
            methods.add(m.getName());
        System.out.println(methods);
return methods;
}
}
