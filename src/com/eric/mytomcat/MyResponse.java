package com.eric.mytomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/15/2018 3:18 PM
 */
public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * 写内容
     * @param content
     */
    public void write(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
          .append("Content-Type: text/html\n")
          .append("\r\n")
          .append("<html><body>")
          .append(content)
          .append("</body></html>");
        try {
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
        }catch (IOException e) {
            try {
                outputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
