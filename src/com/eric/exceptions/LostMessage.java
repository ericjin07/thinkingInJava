package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/22/2018 11:00 PM
 */
public class LostMessage {

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                System.out.println("finally not catch");
//                return;
//                lm.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void f() throws ImportantException {
        throw new ImportantException();
    }

    void dispose() throws HohunException {
        throw new HohunException();
    }
}

class ImportantException extends Exception {
    @Override
    public String toString() {
        return "A important exception";
    }
}

class HohunException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}
