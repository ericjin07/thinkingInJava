package com.eric.interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/17/2018 8:43 PM
 */
public abstract class StringProcessor implements Processor {
    @Override
    public String name() {
        return getClass().getSimpleName();
    }
    public static String s = "If she weights the same as a duck, she's made of wood";
    public abstract String process(Object o) ;

    public static void main(String[] args) {
        Apply.process(new Upcase(),s);
        Apply.process(new Downcase(),s);
        Apply.process(new Swapper(),s);
    }
}

class Upcase extends StringProcessor{
    @Override
    public String process(Object o) {
        return ((String) o).toUpperCase();
    }
}

class Downcase extends StringProcessor {
    @Override
    public String process(Object o) {
        return ((String) o).toLowerCase();
    }
}

class Swapper extends StringProcessor {
    @Override
    public String process(Object o) {
         String s = (String) o;
         char[] arrs = s.toCharArray();
        Arrays.sort(arrs);
        return new String(arrs);
    }
}
