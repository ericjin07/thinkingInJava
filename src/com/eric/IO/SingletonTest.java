package com.eric.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/13/2019 1:28 PM
 */
public class SingletonTest {

    static String file = "C:\\Users\\lanse\\Desktop\\SINGLETON.txt";

    public static void main(String[] args) throws Exception{
        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
//        SingleEnum s = SingleEnum.INSTANCE;
//        SingleEnum s2 = SingleEnum.INSTANCE;
        System.out.println("静态方法获取实例是否一致：" + (s == s2));
//        System.out.println(s.getId());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(s);
        oos.flush();
        System.out.println("write finish");

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Singleton reS = (Singleton) ois.readObject();
//        SingleEnum reS = (SingleEnum) ois.readObject();
//        System.out.println(reS.getId());
        System.out.println("序列化后的实例一致么：" + (reS == s));

//        测试反射：：：
        Constructor<Singleton> cons = Singleton.class.getDeclaredConstructor();
        cons.setAccessible(true);
        Singleton consInstance = cons.newInstance();
        System.out.println("反射生成的实例是否一致：" + (consInstance == s));
    }
}
