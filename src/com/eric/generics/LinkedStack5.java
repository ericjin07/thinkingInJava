package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/09/2019 11:03 PM
 */
public class LinkedStack5<T> {

    private class Node {
        T item;
        Node next;
        public Node() {
            item = null;
            next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public boolean end(){return top.next == null && top.item == null;}

    }
    public void push(T t) {
        top = new Node(t, top);
    }

    public T pop(){
        T res = top.item;
        if (!top.end()) top = top.next;
        return res;
    }

    private Node top = new Node();


    public static void main(String[] args) {
        LinkedStack5<String> stack = new LinkedStack5<>();
        for (String s : "Phaser on stun !".split(" ")) {
            stack.push(s);
        }
        String s;
        while ((s = stack.pop()) != null) {
            System.out.println(s);
        }
    }

}
