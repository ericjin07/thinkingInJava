package com.eric.concurrency;

import enumerated.menu.Course;
import enumerated.menu.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/11/2019 10:58 AM
 */
public class RestaurantWithQueues {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurants restaurant = new Restaurants(exec,3,5);
        exec.execute(restaurant);
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        }else {
            System.out.println("Press 'enter' to exit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

// This is given to the waiter, who gives it to the chef:
class Order {
    private static int counter;
    private final int id = counter++;
    private final Customers customer;
    private final Waiter waiter;
    private final Food food;

    public Order(Customers customer, Waiter waiter, Food food) {
        this.customer = customer;
        this.waiter = waiter;
        this.food = food;
    }

    public Customers getCustomer() {
        return customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public Food getFood() {
        return food;
    }
    public String toString() {
        return "Order: " + id + " item: " + food +
                " for: " + customer +
                " served by: " + waiter;
    }
}

// This is what comes back from the chef:
class Plate {
    private final Order order;
    private final Food food;

    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}

class Waiter implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final Restaurants restaurant;
    BlockingQueue<Plate> filledOrder = new LinkedBlockingQueue<>();

    public Waiter(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrder(Customers customer,Food food) {
        try {
        // Shouldn’t actually block because this is
        // a LinkedBlockingQueue with no size limit:
            restaurant.orders.put(new Order(customer,this,food));
        } catch (InterruptedException e) {
            System.out.println(this + " place order interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Plate plate = filledOrder.take();
                System.out.println(this + " receive " + plate + " delivering to " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "id=" + id +
                '}';
    }
}

class Chefer implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final Restaurants restaurant;
    private static Random rand = new Random(47);

    public Chefer(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Order order = restaurant.orders.take();
                Food food = order.getFood();
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                Plate plate = new Plate(order,food);
                order.getWaiter().filledOrder.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted");
        }
    }

    @Override
    public String toString() {
        return "Chefer{" +
                "id=" + id +
                '}';
    }
}

class Customers implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final Waiter waiter;
    // Only one course at a time can be received:
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customers(Waiter waiter) {
        this.waiter = waiter;
    }

    public void deliver(Plate p) throws InterruptedException {
        // Only blocks if customer is still
        // eating the previous course:
        placeSetting.put(p);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waiter.placeOrder(this, food);
                //block util course has been delivered
                System.out.println(this + " eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + " interrupted");
                break;
            }
        }
        System.out.println(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                '}';
    }
}

class Restaurants implements Runnable {
    private List<Chefer> chefers = new ArrayList<>();
    private List<Waiter> waiters = new ArrayList<>();
    private ExecutorService exec;
    BlockingQueue<Order> orders = new LinkedBlockingQueue<>();
    private static Random rand = new Random(47);

    public Restaurants(ExecutorService exec, int nChef, int nWaiter) {
        this.exec = exec;
        for (int i = 0; i < nChef; i++) {
            Chefer chefer = new Chefer(this);
            chefers.add(chefer);
            exec.execute(chefer);
        }
        for (int i = 0; i < nWaiter; i++) {
            Waiter waiter = new Waiter(this);
            waiters.add(waiter);
            exec.execute(waiter);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                // A new customer arrives; assign a WaitPerson:
                Waiter waiter = waiters.get(rand.nextInt(waiters.size()));
                Customers customer = new Customers(waiter);
                exec.execute(customer);
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Restaurant interrupted");
        }
        System.out.println("Restaurant closing");
    }
}
