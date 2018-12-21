package com.eric.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/20/2018 9:51 PM
 */
public class Ex6_logging {

    public static void main(String[] args) {
        try {
            throw new LogginException_1("haha");
        } catch (LogginException_1 e) {
//            e.printStackTrace();
        }
    }
}

class LogginException_1 extends Exception{
    private static Logger logger = Logger.getLogger("ex1");

    public LogginException_1(String message) {
        super(message);
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
