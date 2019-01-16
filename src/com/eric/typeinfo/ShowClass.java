package com.eric.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/15/2019 10:11 PM
 */
public class ShowClass {
    private static String USAGE = "usage:\n" +
            "ShowClass qualified.class.name\n" +
            "To show all method in class or:\n" +
            "ShowClass qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern methodPattern = Pattern.compile("(\\w+\\.)");
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(0);
        }
        try {
            Class clz = Class.forName(args[0]);
            String name = clz.getSimpleName();
            String modify = Modifier.toString(clz.getModifiers());
            Class up = clz.getSuperclass();
            Class itf[] = clz.getInterfaces();
            StringBuilder sb = new StringBuilder();
            sb.append(modify);
            if (clz.isInterface()) {
                sb.append(" interface ");
                if (itf.length > 0) {
                    sb.append(" extent ");
                    for (Class itfc : itf) {
                        sb.append(itfc.getSimpleName()).append(", ");
                    }
                    sb.delete(sb.length() - 2, sb.length());
                }
            } else {
                sb.append(" class ").append(name);
                if (itf.length > 0) {
                    sb.append(" implements ");
                    for (Class itfc : itf) {
                        sb.append(itfc.getSimpleName()).append(", ");
                    }
                    sb.delete(sb.length() - 2, sb.length());
                }
            }
            sb.append(" {\n");
            getMethods(clz,sb);
            sb.append("}");
            System.out.println(methodPattern.matcher(sb.toString()).replaceAll(""));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getMethods(Class clz, StringBuilder sb) {
        Method[] methods = clz.getMethods();
        Constructor[] cons = clz.getConstructors();
        Field[] fields = clz.getDeclaredFields();
        for (Method method : methods) {
            sb.append("\t\t").append(method.toString()).append(";\n");
        }
        for (Constructor constr : cons)
            sb.append("\t\t").append(constr.toString()).append(";\n");
        for (Field field : fields) {
            sb.append("\t\t").append(field.toString()).append(";\n");
        }
    }
}
