package com.trythis.c12.t01;

import com.randomtasks.enumerations.EnumDemo1;
import com.randomtasks.multithreading.threadImplementsRunnable.MyThreadDemo;

enum TrafficLight {
    RED(5), GREEN(5), ORANGE_BEFORE_RED(2), ORANGE_BEFORE_GREEN(2);
    private int time;
    public int getTime() {
        return time;
    }
    TrafficLight(int time) { this.time = time; }
}

class TrafficLightController implements Runnable {
    private TrafficLight light;
    private boolean stop = false;
    private boolean change = false;

    TrafficLightController() {
        light = TrafficLight.RED;
    }

    TrafficLightController(TrafficLight light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (!stop) {
            changeColor();
            announcer();
        }
    }

    synchronized private void changeColor() {
        try {
            Thread.sleep(light.getTime() * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        switch (light) {
            case RED -> light = TrafficLight.ORANGE_BEFORE_GREEN;
            case ORANGE_BEFORE_GREEN -> light = TrafficLight.GREEN;
            case GREEN -> light = TrafficLight.ORANGE_BEFORE_RED;
            case ORANGE_BEFORE_RED -> light = TrafficLight.RED;
        }
        change = true;
        notify();
    }

    synchronized public void announcer() {
        while (!change) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Traffic light color changed. Current color is " + light);
        change = false;
    }
}

public class TrafficLightDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new TrafficLightController(), "Traffic light");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
