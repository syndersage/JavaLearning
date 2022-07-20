package com.randomtasks.multithreading.synchronization.threadedCounter;

class MyThread implements Runnable {
    String name;
    static int sum;
    MyThread(String name) {
        this.name = name;
    }

    synchronized static private void counter(String name) {
        for (int i = 0; i < 20; i++) {
                System.out.print(name);
        }
    }

    @Override
    public void run() {
        counter(name);
    }
}

public class ThreadedCounterDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyThread( Integer.toString(i)));
            thread.setPriority((i + 1) * 2);
            thread.start();
        }
    }
}
