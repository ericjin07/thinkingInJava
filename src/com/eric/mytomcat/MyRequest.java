package com.eric.mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:11 PM
 */
public class MyRequest {

    private InputStream inputStream;
    private String method;
    private String url;

    public MyRequest(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;

        String httpRequest = "";
        byte[] bytes = new byte[1024];
        int length;
        //read the inputStream
        while ((length = inputStream.read(bytes)) > 0)
            httpRequest = new String(bytes,0,length);

        /**
         * GET /hello HTTP/1.1
         * Host: 127.0.0.1:8077
         * Connection: keep-alive
         * Cache-Control: max-age=0
         * Upgrade-Insecure-Requests: 1
         * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36
         * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng
         */
        if (httpRequest.length() > 10) {
            String header = httpRequest.split("\n")[0];
            System.out.println("header=== " + header);
            method = header.split("\\s")[0];
            url = header.split("\\s")[1];
        }
        System.out.println("http----\n" + httpRequest);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
