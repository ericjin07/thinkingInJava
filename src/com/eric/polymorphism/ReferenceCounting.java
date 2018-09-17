package com.eric.polymorphism;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/16/2018 8:36 PM
 */
public class ReferenceCounting {

    public static void main(String[] args) {
        Share share = new Share();
        Composing[] composings = new Composing[]{new Composing(share),new Composing(share),new Composing(share),new Composing(share),new Composing(share)};
        for (Composing c: composings){
            c.dispose();
        }
        Composing t1 = new Composing(share);
        share.finalize();
        Share share1 = new Share();
        Composing t2 = new Composing(share1);
        t2.dispose();
        share1.finalize();
    }


}

class Share{
    private int referenceCount;
    private static long count;
    private final long id = count++;

    public Share() {
        System.out.println("Creating" + this);
    }

    public void addRef(){
        referenceCount++;
    }

    @Override
    protected void finalize() {
        if (referenceCount > 0){
            System.out.println("error :" + referenceCount + " shared " + id + " is in used");
        }
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                '}';
    }

    public void dispose() {
        if (--referenceCount == 0)
            System.out.println("disposing"+ this);
    }
}

class Composing{
    private Share share;
    private static long count;
    private final long id = count++;

    public Composing(Share share) {
        System.out.println("Creating " + this);
        this.share = share;
        share.addRef();
    }

    public void dispose(){
        System.out.println("dispose composing "+ this);
        share.dispose();
    }

    @Override
    public String toString() {
        return "Composing{" +
                "id=" + id +
                '}';
    }
}
