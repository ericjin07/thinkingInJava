package com.eric.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/19/2018 9:34 PM
 */
class LoggingExceptions extends Exception {

    private static Logger logger = Logger.getLogger("logging Exception");

    public LoggingExceptions() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
        System.out.println(trace);
    }
}

public class LoggingException {

    public static void main(String[] args) {
        try {
            throw new LoggingExceptions();
        } catch (LoggingExceptions e) {
            System.err.println("Caught " + e);
            LoggingExceptions.logException(e);
        }
    }
}
