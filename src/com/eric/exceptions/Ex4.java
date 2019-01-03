package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/19/2018 8:19 PM
 */
public class Ex4 {

    public static void main(String[] args) {
        int x = 0;
        while (true) {
            try {
                if (x < 10)
                    throw new Exception_4("this is the exception 4");
                else break;
            } catch (Exception_4 e) {
                System.out.println(x);
                e.printStackTrace();
//                e.showMessge();
                x++;
            }
        }
        System.out.println("now we are ok");
    }

}

class Exception_4 extends RuntimeException {
    private String msg;
    public Exception_4(String message) {
        super(message);
        this.msg = message;
    }

    public void showMessge() {
        System.out.println(msg);
    }
}
