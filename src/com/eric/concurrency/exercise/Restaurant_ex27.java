package com.eric.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 02/28/2019 4:55 PM
 */
public class Restaurant_ex27 {

    Meal meal;
    boolean needClean;
    WaitPerson waitPerson;
    Chef chef ;
    BusBoy busBoy;
    ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant_ex27() {
        waitPerson = new WaitPerson(this);
        chef = new Chef(this);
        busBoy = new BusBoy(this);
        needClean = false;
        exec.execute(waitPerson);
        exec.execute(chef);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant_ex27();
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

    private Restaurant_ex27 restaurantEx27;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public WaitPerson(Restaurant_ex27 restaurantEx27) {
        this.restaurantEx27 = restaurantEx27;
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    while (restaurantEx27.meal == null)
                        condition.await(); //for chef to produce the meal
                }finally {
                    lock.unlock();
                }
                System.out.print("WaitPerson got the " + restaurantEx27.meal);
                restaurantEx27.chef.lock.lock();
                try {
                    restaurantEx27.meal = null;
                    restaurantEx27.chef.condition.signalAll();
                }finally {
                    restaurantEx27.chef.lock.unlock();
                }
                System.out.println("hey, Busboy to clean the dish");
                restaurantEx27.busBoy.lock.lock();
                try {
                    restaurantEx27.needClean = true;
                    restaurantEx27.busBoy.condition.signalAll();
                }finally {
                    restaurantEx27.busBoy.lock.unlock();
                }
            }
        }catch (InterruptedException e){
            System.out.println("WaitPerson Interrupt");
        }
    }
}

class Chef implements Runnable {

    private Restaurant_ex27 restaurantEx27;
    private static int count;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public Chef(Restaurant_ex27 restaurantEx27) {
        this.restaurantEx27 = restaurantEx27;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    while (restaurantEx27.meal != null)
                        condition.await(); //... for the meal to be token
                }finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    System.out.println("out of food;close restaurantEx27");
                    restaurantEx27.exec.shutdownNow();
                    return;
                }
                restaurantEx27.waitPerson.lock.lock();
                try {
                    System.out.print("order up ");
                    restaurantEx27.meal = new Meal(count);
                    restaurantEx27.waitPerson.condition.signalAll();
                }finally {
                    restaurantEx27.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(300);
            }
        }catch (InterruptedException e){
            System.out.println("Chef Interrupt");
        }
    }
}

class BusBoy implements Runnable {
    private Restaurant_ex27 restaurantEx27;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public BusBoy(Restaurant_ex27 restaurantEx27) {
        this.restaurantEx27 = restaurantEx27;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                lock.lock();
                try {
                    while (!restaurantEx27.needClean)
                        condition.await();
                }finally {
                    lock.unlock();
                }

                System.out.println("I'm busBoy,I have cleaned the dish");
                restaurantEx27.needClean = false;
            }
        }catch (InterruptedException e){
            System.out.println("Bus boy interrupt");
        }
    }
}

