package com.randomtasks.multithreading.secondsCounter;

class TickTock {

    public static String status = "TOCK";

    synchronized public void tick() {
        while (true) {
            if (status.equals("TOCK")) {
                System.out.print("Tick ");
                try {
                    Thread.sleep(500);
                    status = "TICK";
                    notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    return;
                }
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    synchronized public void tock() {
        while (true) {
            if (status.equals("TICK")) {
                System.out.println("Tock");
                try {
                    Thread.sleep(500);
                    status = "TOCK";
                    notify();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                finally {
                    return;
                }
            }
            else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class MyThread implements Runnable {
    Thread thread;
    TickTock tt;
    String tickTock;
    private static int seconds;
    MyThread(String threadName, String tickOrTock, TickTock tt, int seconds) {
        thread = new Thread(this, threadName);
        this.tt = tt;
        this.tickTock = tickOrTock;
        MyThread.seconds = seconds;
    }
    public static MyThread createAndStart(String threadName, String tickOrTock, TickTock tt, int seconds) {
        MyThread mt = new MyThread(threadName, tickOrTock, tt, seconds);
        mt.thread.start();
        return mt;
    }
    @Override
    public void run() {
        for (int i = 0; i < seconds; i++) {
            if (tickTock.equals("TICK")) tt.tick();
            else if (tickTock.equals("TOCK")) tt.tock();
        }
    }
}

public class SecondsCounter {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThread mt1 = MyThread.createAndStart("TickThread", "TICK", tt, 10);
        MyThread mt2 = MyThread.createAndStart("TockThread", "TOCK", tt, 10);
        try {
            mt1.thread.join();
            mt2.thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("END.");
        }
    }
}
