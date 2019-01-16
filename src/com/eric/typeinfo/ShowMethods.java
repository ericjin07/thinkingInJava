package com.eric.typeinfo;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/14/2019 10:47 PM
 */
public class ShowMethods {
    private static String USAGE = "usage:\n" +
            "ShowMethods qualified.class.name\n" +
            "To show all method in class or:\n" +
            "ShowMethods qualified.class.name word\n" +
            "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile("(\\w+\\.)|(\\s*final)|(\\s*native)");
    public static void main(String[] args) {
        StringWriter trace = new StringWriter();
        PrintWriter ps = new PrintWriter(trace);
        if (args.length < 1) {
            System.out.println(USAGE);
            System.exit(0);
        }
        try {
            Class clz = Class.forName(args[0]);
            Method[] methods = clz.getMethods();
            Constructor[] cons = clz.getConstructors();
            Field[] fields = clz.getDeclaredFields();
            Matcher m = p.matcher("");
            for (Method method : methods)
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            for (Constructor constr : cons)
                System.out.println(p.matcher(constr.toString()).replaceAll(""));
            for (Field field : fields) {
                System.out.println(p.matcher(field.toString()).replaceAll(""));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace(ps);
            System.out.println(trace.toString());
        }
    }
}
