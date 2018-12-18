package com.eric.mytomcat;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:29 PM
 */
public class HelloWorldServlet extends MyServlet {

    @Override
    public void get(MyRequest request, MyResponse response) {
        System.out.println("get the Hello World");
        response.write("hello World, I love You");
    }

    @Override
    public void post(MyRequest request, MyResponse response) {
        System.out.println("Post the Hello World");
        response.write("hello World, I love You");
    }
}
