package com.eric.strings;

import java.util.Formatter;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/02/2019 3:22 PM
 */
public class Receipt {

    private double total;
    private Formatter f = new Formatter(System.out);
    private int itemWidth ;
    private int qtyWidth ;
    private int priceWidth ;
    private int pricePrecision;

    private String fTitle;
    private String fItem;
    private String fTotal;

    public Receipt(int itemWidth, int qtyWidth, int priceWidth, int pricePrecision) {
        this.itemWidth = itemWidth;
        this.qtyWidth = qtyWidth;
        this.priceWidth = priceWidth;
        this.pricePrecision = pricePrecision;
        setFormatter();
    }

    private void setFormatter() {
        this.fTitle = "%-" + itemWidth + "s %" + qtyWidth + "s %" + priceWidth + "s\n";
        this.fItem = "%-" + itemWidth + "s %" + qtyWidth + "d %" + priceWidth + "." + pricePrecision + "f\n";
        this.fTotal =  "%-" + itemWidth + "s %" + qtyWidth + "s %" + priceWidth + "." + pricePrecision + "f\n";
    }

    public Receipt() {
        this.itemWidth = 15;
        this.qtyWidth = 5;
        this.priceWidth = 10;
        this.pricePrecision = 2;
        setFormatter();
    }

    public void printTitle() {
        f.format(fTitle,"Item","Qty","Price");
        f.format(fTitle,"----","---","-----");
    }

    public void print(String name,int qty, double price) {
        f.format(fItem, name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format(fTotal, "Tax", "", total * 0.06);
        f.format(fTitle, "", "", "-----");
        f.format(fTotal, "", "", total * 1.06);
    }

    public void possible() {
        f.format("my name is %-10s, and I'm %d year old, I'm not dead,%6b, this is my phone in hex: %h, and  in Math %e","Eric",22,true,123, 12312.2);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt(20,10,20,2);
        receipt.printTitle();
        receipt.print("Jack’s Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();

        receipt.possible();
    }
}
