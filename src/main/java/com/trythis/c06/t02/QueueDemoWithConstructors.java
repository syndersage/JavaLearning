package com.trythis.c06.t02;

import java.util.Scanner;

class Queue {
    private final int[] arr;
    private int index = 0;
    static private final int defaultQueueLength = 10;

    void put(int value) {
        if (index == arr.length) System.out.println("Queue is full!");
        else {
            arr[index++] = value;
            System.out.println("Last queue member updated!");
        }
    }

    int get() {
        if (index == 0) System.out.println("Queue is empty!");
        return index == 0 ? -1 : arr[--index];
    }

    Queue() {
        this(defaultQueueLength);
    }

    Queue(int length) {
        arr = length > 0 ? new int[length] : new int[defaultQueueLength];
    }

    Queue(int[] arr) {
        this(arr, arr.length);
    }

    Queue(int[] arr, int queueSize) {
        if (queueSize < arr.length) queueSize = arr.length;
        this.arr = new int[queueSize];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        index = arr.length;
    }
}

class QueueMenu {
    void showClauses() {
        System.out.print("""
                What to do with queue:
                \t1. Put
                \t2. Get
                Choose one (0 to quit):\s""");
    }

    boolean isValidClause(int clause) {
        return clause >= 0 && clause <= 2;
    }
}

public class QueueDemoWithConstructors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        QueueMenu menu = new QueueMenu();
        Queue queue = new Queue(new int[]{10, 20, 30}, 5);
        while (true){
            do {
                menu.showClauses();
                choice = scan.nextInt();
            } while (!menu.isValidClause(choice));
            if (choice == 0) {
                System.out.println("Quiting...");
                break;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Type integer value to add in queue: ");
                    queue.put(scan.nextInt());
                }
                case 2 -> System.out.println("Obtained value from queue: " + queue.get());
                default -> System.out.println("Menu item chosen incorrect!");
            }
        }
        scan.close();
    }
}
