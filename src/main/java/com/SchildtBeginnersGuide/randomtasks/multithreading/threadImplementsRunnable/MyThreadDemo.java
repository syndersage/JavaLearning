package com.SchildtBeginnersGuide.randomtasks.multithreading.threadImplementsRunnable;

class MyThread implements Runnable {
    Thread thr;

    MyThread(String thr) {
        this.thr = new Thread(this, thr);
    }

    public static MyThread starter(String threadName) {
        MyThread innerThread = new MyThread("Some thread");
        innerThread.thr.start();
        return innerThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Count: " + i);
                Thread.sleep(200);
            }
        }
        catch (InterruptedException exception) {
            System.out.println("Interrupted: " + exception);
        }
        finally {
            System.out.println("Thread " + thr.getName() + " ended.");
        }
    }
}

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread thread = MyThread.starter("Some thr");
        Thread thread2 = new Thread(thread);
        thread2.start();
    }
}
