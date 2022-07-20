package com.randomtasks.multithreading.threadExtendsThread;

class MyThread extends Thread {
    Thread thread;
    MyThread(String name) {
        super(name);
    }

    public static Thread createAndStart(String name) {
        MyThread tempThread = new MyThread(name);
        tempThread.start();
        return tempThread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(200);
                System.out.println("Counter: " + (i + 1));
            }
        }
        catch (InterruptedException exception) {
            System.out.println(exception);
        }
    }
}

class MySecondThread extends MyThread {
    static int sum = 0;
    private final int[] arr;
    MySecondThread(String name, int[] arr) {
        super(name);
        this.arr = arr;
    }

    synchronized void summer() {
        sum = 0;
        for (int item: this.arr) {
            sum += item;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(sum);
        }
        System.out.println("END THREAD #" + thread.getName());
    }

    @Override
    public void run() {
        summer();
    }
}

public class ExtendThreadDemo {
    public static void main(String[] args) {
        MySecondThread thread1 = new MySecondThread("First", new int[] {10, 10, 10, 10});
        MySecondThread thread2 = new MySecondThread("Second", new int[] {1, 1, 1, 1});
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
