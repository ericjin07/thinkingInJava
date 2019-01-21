package com.eric.typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/21/2019 5:21 PM
 */
class NullRobotInvocationHandler implements InvocationHandler {

    private String nullName;
    private Robot proxyId = new NullRobot();

    public NullRobotInvocationHandler(Class<? extends Robot> type) {
        this.nullName = type.getSimpleName() + " NullRobot";
    }

    class NullRobot implements Null, Robot {
        @Override
        public String model() {
            return nullName;
        }

        @Override
        public String name() {
            return nullName;
        }

        @Override
        public List<Operation> operations() {
            return Collections.emptyList();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxyId,args);
    }
}

public class NRobot {

    public static Robot newNullInstance(Class<? extends Robot> type) {
        return (Robot) Proxy.newProxyInstance(NRobot.class.getClassLoader(),new Class[]{Robot.class,Null.class},new NullRobotInvocationHandler(type));
    }

    public static void main(String[] args) {
        Robot[] robots = new Robot[] {new SnowRemovalRobot("Eric.Jin"),newNullInstance(SnowRemovalRobot.class)};
        for (Robot r: robots) {
            Robot.Test.test(r);
            System.out.println("======");
        }
    }

}
