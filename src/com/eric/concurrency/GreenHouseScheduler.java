package com.eric.concurrency;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/07/2019 2:00 PM
 */
public class GreenHouseScheduler {
    private volatile boolean lightOn;
    private volatile boolean waterOn;
    private String thermostat = "Day";
    private ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable even, long delay){
        schedule.schedule(even,delay,TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable even,long initdelay,long period){
        schedule.scheduleAtFixedRate(even,initdelay,period,TimeUnit.MILLISECONDS);
    }

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    class LightOn implements Runnable{
        @Override
        public void run() {
            System.out.println("Light on");
            lightOn = true;
        }
    }

    class LightOff implements Runnable{
        @Override
        public void run() {
            System.out.println("Light off");
            lightOn = false;
        }
    }

    class WaterOn implements Runnable{
        @Override
        public void run() {
            System.out.println("Water on");
            waterOn = true;
        }
    }

    class WaterOff implements Runnable{
        @Override
        public void run() {
            System.out.println("Water off");
            waterOn = false;
        }
    }

    class ThermostatNight implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to Night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {
        @Override
        public void run() {
            System.out.println("Thermostat to Day setting");
            setThermostat("Day");
        }
    }

    class Bell implements Runnable {
        @Override
        public void run() {
            System.out.println("Bing!!!");
        }
    }

    class Terminate implements Runnable {

        @Override
        public void run() {
            System.out.println("Terminating");
            schedule.shutdownNow();

        }
    }


    public static void main(String[] args) {
        GreenHouseScheduler gh = new GreenHouseScheduler();
        gh.schedule(gh.new Terminate(),10000);
        gh.repeat(gh.new WaterOn(),0,1000);
        gh.repeat(gh.new WaterOff(),0,1000);
        gh.repeat(gh.new LightOn(),0,1000);
        gh.repeat(gh.new LightOff(),0,1000);
        gh.repeat(gh.new ThermostatDay(),0,2000);
        gh.repeat(gh.new ThermostatNight(),0,3000);
    }
}
