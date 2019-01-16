package com.eric.typeinfo;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/16/2019 2:50 PM
 */
interface Interface {
    void doSomething();
    void doSomethingElse(String args);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("do something");
    }

    @Override
    public void doSomethingElse(String args) {
        System.out.println("do something else " + args);
    }
}

class ProxyObject implements Interface {
    private Interface proxyId;

    public ProxyObject(Interface proxyId) {
        this.proxyId = proxyId;
    }

    @Override
    public void doSomething() {
        long start = System.currentTimeMillis();
        System.out.println("proxy Do something");
        proxyId.doSomething();
        System.out.println(" consumer time: " + (System.currentTimeMillis() - start));
    }

    @Override
    public void doSomethingElse(String args) {
        long start = System.currentTimeMillis();
        System.out.println("proxy Do something Else " + args);
        proxyId.doSomethingElse(args);
        System.out.println(" consumer time: " + (System.currentTimeMillis() - start));
    }
}

public class SimpleProxyDemo {

    public static void main(String[] args) {
        Interface real = new RealObject();
//        real.doSomething();
//        real.doSomethingElse(" hello world");
        Interface proxy = new ProxyObject(real);
        proxy.doSomething();
        proxy.doSomethingElse(" hello girl");
    }
}
