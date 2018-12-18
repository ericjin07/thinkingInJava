package com.eric.mytomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:32 PM
 */
public class MyServletMappingConfig {

    private static List<MyServletMapping> servletMappings = new ArrayList<>();

    static {
        servletMappings.add(new MyServletMapping("hello","/hello","com.eric.mytomcat.HelloWorldServlet"));
    }

    public static List<MyServletMapping> getServletMappings() {
        return servletMappings;
    }
}
