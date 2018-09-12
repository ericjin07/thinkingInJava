package com.eric.initializationAndClean;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/03/2018 9:47 PM
 */
public class Exercise8 {

    public static void main(String[] args) {
        WebBank webBank = new WebBank(true);
        WebBank webBank2 = new WebBank(true);
        webBank.logOut();
        new WebBank(true);
        System.gc();
    }
}

class WebBank{
    boolean logIn = false;

    public WebBank(boolean logIn) {
        this.logIn = logIn;
    }

    public void logIn(){logIn = true;}
    public void logOut(){logIn = false;}

    @Override
    protected void finalize() throws Throwable {
        if (logIn)
            System.out.println("Error:still log in");
//        super.finalize();
    }
}
