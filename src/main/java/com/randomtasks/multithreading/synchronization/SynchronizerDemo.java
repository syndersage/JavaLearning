package com.randomtasks.multithreading.synchronization;

class SumArray {
    private int sum;
    synchronized int sumArray(int[] arr) {
        sum = 0;
        for (int item:
             arr) {
            sum += item;
            System.out.println(sum);
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        return sum;
    }
}

class MyThread implements Runnable {
    static SumArray array;
    static int summa;
    int[] arr;
    MyThread(int[] arr) {
        array = new SumArray();
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
    }

    @Override
    public void run() {
        System.out.println(array.sumArray(arr));;
    }
}

public class SynchronizerDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread(new int[] {10, 10, 10, 10}), "some thr");
        Thread thread2 = new Thread(new MyThread(new int[] {1, 1, 1, 1, 1}), "second thread");
        thread1.start();
        thread2.start();
    }
}
