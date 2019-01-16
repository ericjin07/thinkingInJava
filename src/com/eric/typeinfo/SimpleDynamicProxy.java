package com.eric.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/16/2019 2:59 PM
 */
class DynamicProxyHandler implements InvocationHandler{
    private Object obj;

    public DynamicProxyHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        method.invoke(obj,args);
        long end = System.currentTimeMillis();

        System.out.println("consumer: " + (end - start));
        return proxy;
    }
}

public class SimpleDynamicProxy {

    public static void consumer(Interface itf) {
        itf.doSomething();
        itf.doSomethingElse("balabala");
    }

    public static void main(String[] args) {
//        consumer(new RealObject());
//        consumer(new ProxyObject(new RealObject()));
        consumer((Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(new RealObject())));
    }
}
