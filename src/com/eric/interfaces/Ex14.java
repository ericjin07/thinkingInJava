package com.eric.interfaces;


import java.util.Scanner;

import static com.eric.Main.print;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/18/2018 9:18 AM
 */
public class Ex14 {
    public static void t(CanDo cd){
        cd.doWhat();
        cd.whoDo();
    }
    public static void w(CanDoEffictive cde){
        cde.howEffictive();
    }
    public static void o(CanDoMore cdm) {
        cdm.howMore();
        cdm.moreWhat();
    }
    public static void g(CanDoFast cdf) {
        cdf.howFast();
        cdf.whatSpeed();
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        t(worker);
        w(worker);
        o(worker);
        g(worker);
    }
}

abstract class Doer{
    abstract void who();
}

class Worker extends Doer implements CanDoEffictive{
    @Override
    public String whoDo() {
        print("whoDo");
        return "whoDo";
    }

    @Override
    public String doWhat() {
        print("doWhat");
        return "doWhat";
    }

    @Override
    public void howFast() {
        print("howFast");
    }

    @Override
    public void whatSpeed() {
        print("whatSpeed");
    }

    @Override
    public void howMore() {
        print("howMore");
    }

    @Override
    public void moreWhat() {
        print("moreWhat");
    }

    @Override
    public void howEffictive() {
        print("Effictive");
    }

    @Override
    void who() {
        print("who");
    }
}

interface CanDo{
    String whoDo();
    String doWhat();
}

interface CanDoFast{
    void howFast();
    void whatSpeed();
}

interface CanDoMore{
    void howMore();
    void moreWhat();
}

interface CanDoEffictive extends CanDo, CanDoFast, CanDoMore{
    void howEffictive();
}