package com.eric.exceptions;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/22/2018 10:41 PM
 */
public class OnOffSwitch {

    private static Switch aSwitch = new Switch();

    public static void main(String[] args) {
        try {
            aSwitch.on();
            f();
            aSwitch.off();
            return;
        } catch (OnException e) {
            e.printStackTrace();
            aSwitch.off();
        } catch (OffException e) {
            e.printStackTrace();
            aSwitch.off();
        } finally {
            System.out.println("finally");
            aSwitch.off();
        }
        System.out.println("end");
    }

    public static void f() throws OnException, OffException{
        System.out.println("fffff");
        throw new RuntimeException();
    }
}

class Switch {
    private boolean status;

    public void on() {
        status = true;
        System.out.println(this);
    }

    public void off() {
        status = false;
        System.out.println(this);
    }

    public boolean read() {
        return status;
    }

    @Override
    public String toString() {
        return status ? "on" : "off";
    }
}

class OnException extends Exception{}
class OffException extends Exception{}
