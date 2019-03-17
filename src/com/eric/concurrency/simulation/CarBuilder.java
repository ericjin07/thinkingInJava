package com.eric.concurrency.simulation;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/11/2019 2:45 PM
 */
public class CarBuilder {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        RobotPool pool = new RobotPool();
        CarQueue
                chassisQueue = new CarQueue(),
                finishedQueue = new CarQueue();

        exec.execute(new EngineRobot(pool));
        exec.execute(new WheelRobot(pool));
        exec.execute(new DriveTrainRobot(pool));
        exec.execute(new ExhaustRobot(pool));
        exec.execute(new FenderRobot(pool));

        exec.execute(new Assemble(chassisQueue,finishedQueue,pool));
        exec.execute(new ChassisBuilder(chassisQueue));
        exec.execute(new CarReport(finishedQueue));
        if (args.length > 0){
            TimeUnit.SECONDS.sleep(Integer.parseInt(args[0]));
        }else {
            System.out.println("Press 'enter' to exit!");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

class Car {
    private final int id;
    private boolean engine,driveTrain,wheels,exhaust,fender;

    public Car(int id) {
        this.id = id;
    }

    public int getId(){return id;}

    public synchronized void addEngine(){engine = true;}

    public synchronized void addDriveTrain(){driveTrain = true;}

    public synchronized void addWheels() {
        wheels = true;
    }

    public synchronized void addExhaust() {exhaust = true;}
    public synchronized void addFender() {fender = true;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", engine=" + engine +
                ", driveTrain=" + driveTrain +
                ", wheels=" + wheels +
                '}';
    }
}

class CarQueue extends LinkedBlockingQueue<Car>{}

class ChassisBuilder implements Runnable {

    private CarQueue chassisQueue;
    private static int counter;

    public ChassisBuilder(CarQueue chassisQueue) {
        this.chassisQueue = chassisQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                //make chassis
                Car car = new Car(counter++);
                //insert into queue
                chassisQueue.put(car);
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("ChassisBuilder Interrupted");
        }
        System.out.println("chassis builder off");
    }
}

class CarReport implements Runnable {

    private CarQueue carQueue;

    public CarReport(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Car car = carQueue.take();
                System.out.println(car);
            }
        } catch (InterruptedException e) {
            System.out.println("CarReport Interrupted");
        }
        System.out.println("Car report off");
    }
}

class Assemble implements Runnable {

    private CarQueue chassisQueue,finishedQueue;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private CyclicBarrier secondBarrier = new CyclicBarrier(3);
    private Car car;
    private RobotPool pool;

    public Assemble(CarQueue chassisQueue, CarQueue finishedQueue, RobotPool pool) {
        this.chassisQueue = chassisQueue;
        this.finishedQueue = finishedQueue;
        this.pool = pool;
    }

    public Car car() {
        return car;
    }

    public CyclicBarrier barrier(){return barrier;}

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car = chassisQueue.take();
                pool.hire(EngineRobot.class,this);
                pool.hire(WheelRobot.class,this);
                pool.hire(DriveTrainRobot.class,this);
                barrier.await();
                System.out.println("wait for second stage");
                pool.hire(ExhaustRobot.class,this,secondBarrier);
                pool.hire(FenderRobot.class,this,secondBarrier);
                secondBarrier.await();
                finishedQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Assemble Interrupted");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Assemble off");
    }
}

abstract class Robot implements Runnable {

    private boolean engage;
    private RobotPool pool;
    protected Assemble assemble;
    private CyclicBarrier barrier;

    public void setBarrier(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public Robot(RobotPool pool) {
        this.pool = pool;
    }

    public Robot assignAssemble(Assemble assemble) {
        this.assemble = assemble;
        return this;
    }

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    abstract protected void performService();

    public synchronized void powerDown() throws InterruptedException {
        engage = false;
        assemble = null;    //disconnect from assemble
        pool.release(this); //put ourselves back into the pool
        while (!engage)
            wait();
    }

    @Override
    public void run() {
        try {
            powerDown();
            while (!Thread.interrupted()) {
                performService();
                if (barrier == null)
                    assemble.barrier().await(); // Synchronize
                else barrier.await();
                //done with my own job
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted " + this);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}

class EngineRobot extends Robot {

    public EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " install engine");
        assemble.car().addEngine();
    }
}

class DriveTrainRobot extends Robot {

    public DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " install Drive Train");
        assemble.car().addDriveTrain();
    }
}

class WheelRobot extends Robot {

    public WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " install Wheels");
        assemble.car().addWheels();
    }
}

class ExhaustRobot extends Robot {

    public ExhaustRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " install exhaust System");
        assemble.car().addExhaust();
    }
}

class FenderRobot extends Robot {

    public FenderRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " install fender");
        assemble.car().addFender();
    }
}

class RobotPool {

    private Set<Robot> pool = new HashSet<>();

    private synchronized void add(Robot r){
        pool.add(r);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType,Assemble assemble, CyclicBarrier barrier) throws InterruptedException {
        for (Robot r : pool){
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssemble(assemble);
                r.engage();
                r.setBarrier(barrier);
                return ;
            }
        }
        //if none available wait
        wait();
        hire(robotType,assemble,barrier);
    }

    public synchronized void hire(Class<? extends Robot> robotType,Assemble assemble) throws InterruptedException {
        hire(robotType, assemble,null);
    }


    public synchronized void release(Robot robot) {
        add(robot);
    }
}