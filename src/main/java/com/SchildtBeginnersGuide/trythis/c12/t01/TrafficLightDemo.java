package com.SchildtBeginnersGuide.trythis.c12.t01;

enum TrafficLight {
    ORANGE_BEFORE_RED(2), RED(5), ORANGE_BEFORE_GREEN(2), GREEN(5);
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
        light = TrafficLight.values()[(light.ordinal() + 1) % TrafficLight.values().length];
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
