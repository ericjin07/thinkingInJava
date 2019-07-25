package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/15/2019 11:24 AM
 */
class Employee{}

public class ClassAsFactory<T> {

    private T t;

    public ClassAsFactory(Class<T> kind) {
        try {
            t = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println(fe.t);

        ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        System.out.println(fi.t);
    }
}
