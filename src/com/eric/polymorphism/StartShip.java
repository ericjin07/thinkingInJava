package com.eric.polymorphism;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/16/2018 9:33 PM
 */
public class StartShip {

    public static void main(String[] args) {
        AlertStatus status = new AlertStatus();
        status.alert();
        status.change();
        status.alert();
        status.change();
        status.alert();
        status.change();
    }
}

class AlertStatus{
    private int status;

    public void change(){
        this.status ++;
    }

    public void alert(){
        switch (status % 3){
            case 0:
                System.out.println("start");
                break;
            case 1:
                System.out.println("continuing");
                break;
            case 2:
                System.out.println("stop");
                break;
        }
    }
}
