package com.SchildtBeginnersGuide.trythis.c05.t02;

import java.util.Scanner;

class Queue {
    int[] arr;
    int putIndex, getIndex;

    void put(int value) {
        if (putIndex == arr.length) {
            System.out.println("Queue is full");
            return;
        }
        arr[putIndex++] = value;
    }

    int get() {
        if (getIndex == putIndex) {
            System.out.println("Queue is empty. Returned value: 0");
            return 0;
        }
        return arr[getIndex++];
    }

    Queue(int size) {
        arr = new int[size];
        putIndex = getIndex = 0;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
        Scanner scan = new Scanner(System.in);
        byte choice;
        while (true) {
            do {
                System.out.print("""
                        What to do?
                        \t1.Put
                        \t2.Get
                        Enter your choice (0 to quit):\s""");
                choice = (byte) scan.nextInt();
            } while (choice < 0 || choice > 2);
            if (choice == 0) break;
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to add in queue: ");
                    queue.put(scan.nextInt());
                }
                case 2 -> {
                    int value = queue.get();
                    System.out.println("First value in queue is: " + value);
                }
                default -> System.out.println("Incorrect clause");
            }
        }
    }

}
