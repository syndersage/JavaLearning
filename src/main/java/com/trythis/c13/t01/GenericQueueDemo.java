package com.trythis.c13.t01;


import java.io.FileNotFoundException;
import java.util.Arrays;



class QueueMenu {
    enum QueueMenuItems {
        POP("Pop", "Put new item at the end of queue"), PUSH("Push", "Get first item from the queue"), CLEAR("Clear", "Remove all items from the queue"), ABILITIES("Description", "Get description about menu items");
        private final String description;
        private final String nameToDisplay;
        QueueMenuItems(String nameToDisplay, String description) {
            this.nameToDisplay = nameToDisplay;
            this.description = description;
        }
        public static QueueMenuItems getMenuItemByIndex(int index) throws IndexOutOfBoundsException {
            if (index < QueueMenuItems.values().length && index >= 0) return QueueMenuItems.values()[index];
            else throw new IndexOutOfBoundsException("Selection out of range!");
        }
        public static QueueMenuItems getMenuItemByIndex(String strIndex) throws IndexOutOfBoundsException, NumberFormatException {
            int index = Integer.parseInt(strIndex);
            if (index < QueueMenuItems.values().length && index >= 0) return QueueMenuItems.values()[index];
            else throw new IndexOutOfBoundsException("Selection out of range!");
        }
    }
    public static void getMenu(boolean withDescriptions) {
        for (int i = 0; i < QueueMenuItems.values().length; i++) {
            System.out.println(i + 1 + ". " + (withDescriptions ? QueueMenuItems.values()[i] + " - " + QueueMenuItems.values()[i].description : QueueMenuItems.values()[i].nameToDisplay));
        }
    }
}

interface IQueue<T> {
    void push(T item) throws FullQueueException;
    T pop() throws EmptyQueueException;
}

class FullQueueException extends Exception {
    private final int length;
    FullQueueException(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Queue is full. Max size: " + length;
    }
}

class EmptyQueueException extends Exception {
    @Override
    public String toString() {
        return "Queue is empty! No items available to pop";
    }
}

class Queue<T extends Number> implements IQueue<T> {
    private final T[] queue;
    private int index;

    Queue(T[] queue) {
        this.queue = queue;
        this.index = queue.length - 1;
    }

    @Override
    public T pop() throws EmptyQueueException {
        if (index >= 0) {
            T tempReturn = queue[0];
            System.arraycopy(queue, 1, queue, 0, index--);
            return tempReturn;
        }
        else throw new EmptyQueueException();
    }

    @Override
    public void push(T item) throws FullQueueException {
        if (index < queue.length - 1) {
            queue[++index] = item;
        }
        else throw new FullQueueException(queue.length);
    }
}

public class GenericQueueDemo {
    public static void main(String[] args) {
        QueueMenu.getMenu(false);
        Double[] arr = {1.0, 5.0, 10.0, -0.09};
        Queue<Double> queue = new Queue<>(arr);
        try {
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            queue.push(100.0);
            queue.push(15.1);
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
        }
        catch (FullQueueException | EmptyQueueException e) {
            System.out.println(e);
        }
    }
}
