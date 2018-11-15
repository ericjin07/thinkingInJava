package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 8:44 PM
 */
public class NestClass18 {
    public static class Nest{
        int val;

        public Nest(int val) {
            this.val = val;
        }

        public int getVal(){
            return val;
        }
        private  class NestNest{
            private class NestNestNest{
                void f(){
                    System.out.println("fff");
                }
                private void g(){
                    System.out.println("ggg");
                }
            }
        }
    }

    public static void main(String[] args) {
        Nest nest = new Nest(12);
        Nest.NestNest.NestNestNest nest1 = nest.new NestNest().new NestNestNest();
        nest1.f();
        nest1.g();
        System.out.println(nest.getVal());
    }
}
