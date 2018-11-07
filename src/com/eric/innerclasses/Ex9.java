package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/07/2018 10:12 PM
 */
interface InterEx9{
    void hi(String s);
}
public class Ex9 {

    private class InnerEx9 implements InterEx9{
        @Override
        public void hi(String s) {
            System.out.println(s);
        }
    }

    InterEx9 getInner(){
        return new InnerEx9();
    }

    public InterEx9 saySomething(String s){
        if(s.equals("hello")) {
            class Inner implements InterEx9 {
                @Override
                public void hi(String s) {
                    System.out.println(s);
                }

                Inner() {
                    hi(s);
                }
            }
            return new Inner();
        }else{
            return null;
        }
    }

    public static void main(String[] args) {
        Ex9 ex9 = new Ex9();
        ex9.saySomething("hellods");
        ((InnerEx9)ex9.getInner()).hi("dasd");
    }
}
