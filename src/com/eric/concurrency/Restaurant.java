package com.eric.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 4:55 PM
 */
public class Restaurant {

    Meal meal;
    boolean needClean;
    WaitPerson waitPerson;
    Chef chef ;
    BusBoy busBoy;
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        waitPerson = new WaitPerson(this);
        chef = new Chef(this);
        busBoy = new BusBoy(this);
        needClean = false;
        exec.execute(waitPerson);
        exec.execute(chef);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class Meal{
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal "  + orderNum + "\n";
    }
}

class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null)
                        wait(); //for chef to produce the meal
                }
                System.out.print("WaitPerson got the " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                System.out.println("hey, Busboy to clean the dish");
                synchronized (restaurant.busBoy) {
                    restaurant.needClean = true;
                    restaurant.busBoy.notifyAll();
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson Interrupt");
        }
    }
}

class Chef implements Runnable {

    private Restaurant restaurant;
    private static int count;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this){
                    while (restaurant.meal != null)
                        wait(); //... for the meal to be token
                }
                if (++count == 10) {
                    System.out.println("out of food;close restaurant");
                    restaurant.exec.shutdownNow();
                    return;
                }
                synchronized (restaurant.waitPerson) {
                    System.out.print("order up ");
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(300);
            }
        }catch (InterruptedException e){
            System.out.println("Chef Interrupt");
        }
    }
}

class BusBoy implements Runnable {
    private Restaurant restaurant;

    public BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    while (!restaurant.needClean)
                        wait();
                }
                System.out.println("I'm busBoy,I have cleaned the dish");
                restaurant.needClean = false;
            }
        }catch (InterruptedException e){
            System.out.println("Bus boy interrupt");
        }
    }
}

