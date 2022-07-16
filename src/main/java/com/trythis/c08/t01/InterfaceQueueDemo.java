package com.trythis.c08.t01;

import java.util.Arrays;
import java.util.Scanner;

interface Queue {
    int defaultStartIndex = 0;
    String defaultName = "Default";
    void push(int x) throws FullQueueException;
    default void emptyQueuePop() { System.out.println("Action failed! Queue is empty!"); }
    default void fullQueuePush() { System.out.println("Action failed! Queue is full!"); }
    int pop() throws EmptyQueueException;
    void resetQueue();
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

    public void push(int x) throws FullQueueException {
        if (index == arr.length) {
            validAction = false;
            throw new FullQueueException(arr.length);
        }
        arr[index++] = x;
        validAction = true;
    }

    public int pop() throws EmptyQueueException {
        if (index == 0) {
            validAction = false;
            throw new EmptyQueueException();
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

    @Override
    public void resetQueue() {
        Arrays.fill(arr, 0);
        index = 0;
        System.out.println("Queue successfully reset");
    }
}

class CircularQueue implements Queue {
    private final int[] arr;
    private int index;
    private int poppedInARow;
    private final String name;

    CircularQueue(int size, String name) {
        arr = new int[size];
        index = 0;
        this.name = name;
        this.poppedInARow = arr.length;
    }

    CircularQueue(int[] arr, String name) {
        this.arr = new int[arr.length];
        System.arraycopy(arr, 0, this.arr, 0, arr.length);
        index = 0;
        this.name = name;
        this.poppedInARow = arr.length;
    }

    public void push(int x) {
        if (index == arr.length) index = 0;
        if (poppedInARow > 0) {
            poppedInARow -= 1;
        }
        arr[index++] = x;
    }

    public int pop() throws EmptyQueueException {
        if (index == 0) index = arr.length;
        if (poppedInARow == arr.length) {
            throw new EmptyQueueException();
        }
        poppedInARow += 1;
        return arr[--index];
    }

    public String getQueueName() { return name; }

    @Override
    public void resetQueue() {
        Arrays.fill(arr, 0);
        index = 0;
        System.out.println("Queue successfully reset");
    }
}

class DynamicQueue implements Queue {
    protected final int change;
    protected int[] arr;
    public final static int defaultChange = 2;
    private final int defaultSize;
    protected int index;
    private final String name;
    public void increaseQueue() {
        var tempArr = new int[arr.length + change];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        arr = tempArr;
        System.out.println("Queue size has been increased");
    }
    DynamicQueue(int size, int change, String name) {
        this.change = change;
        this.arr = new int[size];
        this.index = defaultStartIndex;
        this.name = name;
        this.defaultSize = arr.length;
    }

    DynamicQueue(int size, String name) {
        this(size, defaultChange, name);
    }

    DynamicQueue(int size) {
        this(size, defaultChange, defaultName);
    }

    public void push(int x) {
        if (index == arr.length) increaseQueue();
        arr[index++] = x;
    }

    public int pop() throws EmptyQueueException {
        if (index == 0) throw new EmptyQueueException();
        return arr[--index];
    }

    public String getQueueName() {
        return name;
    }

    public void resetQueue() {
        arr = new int[defaultSize];
        index = 0;
        System.out.println("Queue successfully reset");
    }
}

class DecreaseAbleDynamicQueue extends DynamicQueue {
    DecreaseAbleDynamicQueue(int size) {
        super(size);
    }
    DecreaseAbleDynamicQueue(int size, String name) {
        super(size, name);
    }
    DecreaseAbleDynamicQueue(int size, int change, String name) {
        super(size, change, name);
    }

    public void decreaseQueue() {
        var tempArr = new int[arr.length - change];
        System.arraycopy(arr, 0, tempArr, 0, arr.length - change);
        arr = tempArr;
        System.out.println("Queue size has been decreased");
    }

    @Override
    public int pop() throws EmptyQueueException {
        if (index == 0) throw new EmptyQueueException();
        var tempReturn = arr[--index];
        if (index == arr.length - change) decreaseQueue();
        return tempReturn;
    }
}

class FullQueueException extends Exception {
    private final int size;
    FullQueueException(int size) {
        this.size = size;
    }
    public String toString() {
        return "Cannot push to queue. Queue is full! Max size: " + size;
    }
}

class EmptyQueueException extends Exception {
    public String toString() {
        return "Cannot pop from queue. Queue is empty!";
    }
}

class QueueMenu {

    static void QueueTypes() {
        System.out.print("""
                Which type of queue create:
                \t1. Linear
                \t2. Circular
                \t3. Dynamic
                \t4. Dynamic (decrease able)
                Choose one (0 to quit):\s""");
    }

    static boolean isValidType(int clause) { return clause <= 4 && clause >= 0; }

    static void QueueOptions() {
        System.out.print("""
                What to do with queue:
                \t1. Push
                \t2. Pop
                \t3. Reset
                Choose one (0 to quit):\s""");
    }
    static boolean isValidQueue(int clause) {
        return clause >= 0 && clause <= 3;
    }
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
            case 0 -> {
                System.out.println("Quiting...");
                return;
            }
            case 1 -> queue = new LinearQueue(4, "Linear 1");
            case 2 -> queue = new CircularQueue(3, "Circular 1");
            case 3 -> queue = new DynamicQueue(3, "Dynamic 1");
            case 4 -> queue = new DecreaseAbleDynamicQueue(2, 3, "DecreaseAbleDynamic");
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
            if (menuItem == 0) {
                System.out.println("Quiting...");
                break;
            }
            try {
                switch (menuItem) {
                    case 1 -> {
                        System.out.print("Enter integer value to add in " + queue.getQueueName() + " queue: ");
                        queue.push(scan.nextInt());
                    }
                    case 2 -> {
                        int popped = queue.pop();
                        System.out.println("Obtained value from " + queue.getQueueName() + " queue: " + popped);
                    }
                    case 3 -> queue.resetQueue();
                    default ->  System.out.println("Incorrect menu item!");
                }
            }
            catch (FullQueueException | EmptyQueueException e) {
                System.out.println(e);
            }
        }
    }
}
