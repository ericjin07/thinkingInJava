package com.eric.mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:35 PM
 */
public class MyTomcat {

    private int port;
    private static Map<String,String> urlMapping;

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        initialServletMapping();

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(serverSocket);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            MyRequest myRequest = new MyRequest(inputStream);
            MyResponse myResponse = new MyResponse(outputStream);

            dispatcher(myRequest,myResponse);
            socket.close();
        }
    }

    private void dispatcher(MyRequest request, MyResponse response) {
        String url = request.getUrl();
        String clazz = urlMapping.get(url);

        try {
            Class<MyServlet> servletClazz = (Class<MyServlet>) Class.forName(clazz);
            MyServlet servlet = servletClazz.newInstance();
            servlet.service(request,response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void initialServletMapping() {
        urlMapping = new HashMap<>();
        for (MyServletMapping mapping : MyServletMappingConfig.getServletMappings())
            urlMapping.put(mapping.getUrl(),mapping.getClazz());
    }

    public static void main(String[] args) throws IOException {
        MyTomcat tomcat = new MyTomcat(8077);
       tomcat.start();
    }
}
