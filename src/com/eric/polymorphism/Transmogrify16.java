package com.eric.polymorphism;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/16/2018 9:40 PM
 */
public class Transmogrify16 {

    public static void main(String[] args) {
        Starship ss = new Starship();
        ss.checkAlertStatus();
        ss.highAlert();
        ss.checkAlertStatus();
        ss.maximumAlert();
        ss.checkAlertStatus();
        ss.normalAlert();
        ss.checkAlertStatus();
    }
}


class AlertStatus2 {
    public void alert() {}
}

class NormalAlert extends AlertStatus2 {
    public void alert() {
        System.out.println("AlertStatus Normal"); }
}

class HighAlert extends AlertStatus2 {
    public void alert() { System.out.println("AlertStatus High"); }
}

class MaximumAlert extends AlertStatus2 {
    public void alert() { System.out.println("AlertStatus Maximum"); }
}

class Starship {
    private AlertStatus2 alertStatus = new NormalAlert();
    public void normalAlert() { alertStatus = new NormalAlert(); }
    public void highAlert() { alertStatus = new HighAlert(); }
    public void maximumAlert() { alertStatus = new MaximumAlert(); }
    public void checkAlertStatus() { alertStatus.alert(); }
}
