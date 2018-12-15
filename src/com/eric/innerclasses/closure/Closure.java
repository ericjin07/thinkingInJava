package com.eric.innerclasses.closure;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/19/2018 11:35 AM
 */
interface Callback {
    void printFinsh(String msg);
}

class Printer{

    public void print(Callback callback, String cont){
        System.out.println("正在打印");
        try {
            Thread.currentThread();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.printFinsh(cont);
    }
}

class People{
    Printer printer = new Printer();

    //同步回调
    public void toPrintSyn(Callback callback,String msg){
        printer.print(callback,msg);
    }

    //异步回调
    public void toPrintASyn(Callback callback,String msg){
        new Thread(new Runnable() {
            @Override
            public void run() {
                printer.print(callback,msg);
            }
        }).start();
    }
}

public class Closure{
    public static void main(String[] args) {
        People people = new People();
        Callback callback = new Callback() {
            @Override
            public void printFinsh(String msg) {
                System.out.println("打印机告诉我的消息是 " + msg);
            }
        };
        System.out.println("需要打印的内容是 " + "——————打印一份简历");
        people.toPrintSyn(callback,"打印一份简历");
//        people.toPrintASyn(callback,"打印一份简历");
        System.out.println("我在等待 打印机  反馈");
    }
}

