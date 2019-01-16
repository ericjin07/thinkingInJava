package com.eric.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/16/2019 2:08 PM
 */
class MethodSelector implements InvocationHandler {

    private Object proxyObj;

    public MethodSelector(Object proxyObj) {
        this.proxyObj = proxyObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().matches("interesting"))
            System.out.println("this is a interesting proxy Method");
        return method.invoke(proxyObj,args);
    }
}

interface SomeMethons {
    void boring();
    void boring_1();
    void interesting(String args);
}

class SomeMethonsImp implements SomeMethons {
    @Override
    public void boring() {
        System.out.println("boring");
    }

    @Override
    public void boring_1() {
        System.out.println("boring 111111");
    }

    @Override
    public void interesting(String args) {
        System.out.println("oh, this is a interesting method " + args);
    }
}

public class SelectingMethons {

    public static void main(String[] args) {
        SomeMethons sm = (SomeMethons) Proxy.newProxyInstance(SomeMethons.class.getClassLoader(),new Class[]{SomeMethons.class},new MethodSelector(new SomeMethonsImp()));
        sm.boring();
        sm.boring_1();
        sm.interesting(":fasdfasdf");
    }
}
