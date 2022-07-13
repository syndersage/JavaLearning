package com.trythis.c08.t01;

import java.util.Scanner;

interface Queue {
    int defaultSize = 10;
    int defaultStartIndex = 0;
    String defaultName = "Default";
    void push(int x);
    default void emptyQueuePop() { System.out.println("Action failed! Queue is empty!"); }
    default void fullQueuePush() { System.out.println("Action failed! Queue is full!"); }
    int pop();
    String getQueueName();
}

class LinearQueue implements Queue {
    private final int[] arr;
    private int index;
    private final String name;
    private boolean validAction = false;

    LinearQueue(int size, String name) {
        arr = new int[size];
        index = Queue.defaultStartIndex;
        this.name = name;
    }

    LinearQueue(int[] arr, String name) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        index = Queue.defaultStartIndex;
        this.name = name;
    }

    LinearQueue(int size) {
        this(size, defaultName);
    }

    LinearQueue(int[] arr) {
        this(arr, defaultName);
    }

    public void push(int x) {
        if (index == arr.length) {
            fullQueuePush();
            validAction = false;
            return;
        }
        arr[index++] = x;
        validAction = true;
    }

    public int pop() {
        if (index == 0) {
            emptyQueuePop();
            validAction = false;
            return -1;
        }
        validAction = true;
        return arr[--index];
    }

    public String getQueueName() {
        return name;
    }

    public boolean lastActionValid() {
        return validAction;
    }
}

class QueueMenu {

    static void QueueTypes() {
        System.out.print("""
                Which type of queue create:
                \t1. Linear
                \t2. Circular
                Choose one (0 to quit):\s""");
    }

    static boolean isValidType(int clause) { return clause <= 2 && clause >= 0; }

    static void QueueOptions() {
        System.out.print("""
                What to do with queue:
                \t1. Push
                \t2. Pop
                Choose one (0 to quit):\s""");
    }
    static boolean isValidQueue(int clause) {
        return clause >= 0 && clause <= 2;
    }
}

class CircularQueue implements Queue {
    private final int[] arr;
    private int index;
    private final String name;

    CircularQueue(int size, String name) {
        arr = new int[size];
        index = 0;
        this.name = name;
    }

    CircularQueue(int[] arr, String name) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        index = 0;
        this.name = name;
    }

    public void push(int x) {
        if (index == arr.length) index = 0;
        arr[index++] = x;
    }

    public int pop() {
        if (index == 0) index = arr.length;
        return arr[--index];
    }

    public String getQueueName() { return name; }
}

public class InterfaceQueueDemo {
    public static void main(String[] args) {
        int menuItem;
        var scan = new Scanner(System.in);
        Queue queue;
        do {
            QueueMenu.QueueTypes();
            menuItem = scan.nextInt();
        } while (!QueueMenu.isValidType(menuItem));
        switch (menuItem) {
            case 1 -> queue = new LinearQueue(4, "Linear 1");
            case 2 -> queue = new CircularQueue(3, "Circular 1");
            default -> {
                System.out.println("Incorrect menu item!");
                return;
            }
        }
        while (true) {
            QueueMenu.QueueOptions();
            do {
                menuItem = scan.nextInt();
            } while (!QueueMenu.isValidQueue(menuItem));
            if (menuItem == 0) break;
            switch (menuItem) {
                case 1 -> {
                    System.out.print("Enter integer value to add in " + queue.getQueueName() + " queue: ");
                    queue.push(scan.nextInt());
                }
                case 2 -> {
                    int popped = queue.pop();
                    System.out.println("Obtained value from " + queue.getQueueName() + " queue: " + popped);
                }
                default ->  System.out.println("Incorrect menu item!");
            }
        }
    }
}
