package com.eric.concurrency;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/08/2019 1:23 PM
 */
public class BankTellSimulation {

    private static int SIZE = 25;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        //If line is too long, customers will leave:
        CustomerLine line = new CustomerLine(SIZE);
        exec.execute(new CustomerGenerator(line));
        // Manager will add and remove tellers as necessary:
        exec.execute(new TellerManager(200,line,exec));
        if (args.length > 0)
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        else {
            System.out.println("press 'enter' to exit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

class Customer {
    private int serverTime;
    private static int counter;
    private final int id = counter++;

    public Customer(int serverTime) {
        this.serverTime = serverTime;
    }

    public int getServerTime() {
        return serverTime;
    }

    @Override
    public String toString() {
        return String.format("C%d[%d]",id,serverTime);
    }
}

//Teach the customer line to display itself
class CustomerLine extends ArrayBlockingQueue<Customer> {

    public CustomerLine(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        if (this.size() == 0)
            return "[Empty]";
        StringBuilder sb = new StringBuilder();
        for(Customer c:this){
            sb.append(c);
        }
        return sb.toString();
    }
}

//Randomly add a customer to a queue
class CustomerGenerator implements Runnable {
    private CustomerLine line;
    private static Random rand = new Random(47);

    public CustomerGenerator(CustomerLine line) {
        this.line = line;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                line.add(new Customer(rand.nextInt(1000)));
            }
        } catch (InterruptedException e) {
            System.out.println("Customer Generator interrupted");
        }
        System.out.println("Customer Generator finished");
    }
}

class Teller implements Runnable,Comparable<Teller> {

    private static int counter;
    private final int id = counter++;
    private int customerServed;
    private CustomerLine line;
    private boolean servingCustomerLine = true;

    public Teller(CustomerLine line) {
        this.line = line;
    }

    @Override
    public int compareTo(Teller o) {
        return Integer.compare(this.customerServed, o.customerServed);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                //server the customer for the customer server time
                Customer customer = line.take();
                TimeUnit.MILLISECONDS.sleep(customer.getServerTime());
                synchronized (this) {
                    if (!servingCustomerLine)
                        wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted");
        }
        System.out.println(this + " terminal");
    }

    public synchronized void doSomethingElse() {
        servingCustomerLine = false;
        customerServed = 0;
    }

    public synchronized void serverCustomerLine() {
        assert !servingCustomerLine:"already serving: " + this;
        servingCustomerLine = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Teller{" +
                "id=" + id +
                '}';
    }

    public String shortName() {
        return "T" + id;
    }
}

class TellerManager implements Runnable {
    private int adjustPeriod;
    private CustomerLine line;
    private PriorityQueue<Teller> workingTells = new PriorityQueue<>();
    private Queue<Teller> doingOtherThingsTells = new LinkedList<>();
    private ExecutorService exec;

    public TellerManager(int adjustPeriod, CustomerLine line, ExecutorService exec) {
        this.adjustPeriod = adjustPeriod;
        this.line = line;
        this.exec = exec;
        //start a single teller
        Teller t = new Teller(line);
        exec.execute(t);
        workingTells.add(t);
    }

    public void adjustTellerNumber() {
        //this is actually a control system. By adjusting the numbers, you can reveal stability issue in the control mechanism
        //if line is too long , add another teller
        if (line.size() / workingTells.size() > 2) {
            //if teller are on break or doing other things,bring them back
            if (doingOtherThingsTells.size() > 0) {
                Teller t = doingOtherThingsTells.remove();
                t.serverCustomerLine();
                workingTells.offer(t);
                return;
            }
            //else create or hire a new teller
            Teller t = new Teller(line);
            exec.execute(t);
            workingTells.offer(t);
            return;
        }
        //if line is short to enough, remove a tell
        if (workingTells.size() > 1 && line.size() / workingTells.size() < 2)
            reaasignOneTeller();
        //if there is no-line, we only need one teller
        if (line.size() == 0)
            while (workingTells.size() > 1)
                reaasignOneTeller();
    }

    private void reaasignOneTeller() {
        Teller t = workingTells.remove();
        t.doSomethingElse();
        doingOtherThingsTells.offer(t);
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(adjustPeriod);
                adjustTellerNumber();
                System.out.print(line + " { ");
                for (Teller t : workingTells)
                    System.out.print(t.shortName() + " ");
                System.out.println(" }");
            }
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted");
        }
        System.out.println(this + " finished");
    }

    @Override
    public String toString() {
        return "TellerManager";
    }
}