package com.eric.mytomcat;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:25 PM
 */
public abstract class MyServlet {

    public abstract void get(MyRequest request, MyResponse response);

    public abstract void post(MyRequest request, MyResponse response);

    public void service(MyRequest request, MyResponse response) {
        if (request.getMethod().equalsIgnoreCase("GET"))
            get(request,response);
        else if (request.getMethod().equalsIgnoreCase("POST"))
            post(request,response);
    }
}
