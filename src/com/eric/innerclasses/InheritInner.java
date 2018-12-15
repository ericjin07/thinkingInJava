package com.eric.innerclasses;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/19/2018 1:39 PM
 */
public class InheritInner {

    class InheritInnerer extends WithInner.Inner{

        public InheritInnerer(WithInner withInner,String msg) {
            withInner.super(msg);
        }
    }

    public InheritInnerer getInner(WithInner withInner,String msg){
        return new InheritInnerer(withInner,msg);
    }

    public static void main(String[] args) {
        InheritInner i = new InheritInner();
        i.getInner(new WithInner(),"somemte");
    }
}

class WithInner{

    class Inner{
        String msg;
        public Inner(String msg) {
            this.msg = msg;
            System.out.println(msg);
        }
    }
}
