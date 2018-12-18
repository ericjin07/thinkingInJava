package com.eric.mytomcat;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:31 PM
 */
public class MyServletMapping {

    private String mapping;
    private String url;
    private String clazz;

    public MyServletMapping(String mapping, String url, String clazz) {
        this.mapping = mapping;
        this.url = url;
        this.clazz = clazz;
    }

    public String getMapping() {
        return mapping;
    }

    public String getUrl() {
        return url;
    }

    public String getClazz() {
        return clazz;
    }
}
