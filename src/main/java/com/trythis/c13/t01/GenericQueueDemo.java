package com.trythis.c13.t01;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


class QueueMenu {
    enum QueueMenuItems {
        POP("Pop", "Put new item at the end of queue"), PUSH("Push", "Get first item from the queue"), CLEAR("Clear", "Remove all items from the queue (i.e. make it empty)"), ABILITIES("Description", "Get description about menu items"), STOP("Stop", "Leave from queue redactor menu");
        private final String description;
        private final String nameToDisplay;
        QueueMenuItems(String nameToDisplay, String description) {
            this.nameToDisplay = nameToDisplay;
            this.description = description;
        }
//        public static QueueMenuItems getMenuItemByIndex(String strIndex) throws IndexOutOfBoundsException, NumberFormatException {
//            int index = Integer.parseInt(strIndex);
//            if (index < QueueMenuItems.values().length && index >= 0) return QueueMenuItems.values()[index];
//            else throw new IndexOutOfBoundsException("Selection out of range!");
//        }
    }
    public static QueueMenuItems getMenuItemByIndex(int index) throws IndexOutOfBoundsException {
        if (index < QueueMenuItems.values().length && index >= 0) return QueueMenuItems.values()[index];
        else throw new IndexOutOfBoundsException("Selection out of range!");
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
    void clear();
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

    @Override
    public void clear() {
        index = 0;
    }
}

public class GenericQueueDemo {
    public static void main(String[] args) {
        Double[] arr = {1.0, 5.0, 10.0, -0.09};
        var queue = new Queue<>(arr);
        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.ENGLISH);
        boolean descriptions = false;
        menuLoop:
        {
            while (true) {
                QueueMenu.getMenu(descriptions);
                System.out.print("Choose one: ");
                descriptions = false;
                QueueMenu.QueueMenuItems menuItem;
                while (true) {
                    try {
                        menuItem = QueueMenu.getMenuItemByIndex(scan.nextInt() - 1);
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Incorrect input!");
                        scan.next();
                        QueueMenu.getMenu(descriptions);
                        System.out.print("Choose one: ");
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                        QueueMenu.getMenu(descriptions);
                        System.out.print("Choose one: ");
                    }
                    catch (Exception e) {
                        break menuLoop;
                    }
                }
                try {
                    switch (menuItem) {
                        case POP -> System.out.println("Obtained value: " + queue.pop());
                        case PUSH -> {
                            try {
                                System.out.print("Enter value to add in queue: ");
                                queue.push(scan.nextDouble());
                            } catch (InputMismatchException e) {
                                System.out.println("Incorrect input format for the queue!");
                                scan.next();
                            }
                        }
                        case CLEAR -> {
                            queue.clear();
                            System.out.println("Queue successfully cleared!");
                        }
                        case ABILITIES -> descriptions = true;
                        case STOP -> {
                            System.out.println("Quiting...");
                            break menuLoop;
                        }
                    }
                } catch (FullQueueException | EmptyQueueException e) {
                    System.out.println("Queue error! " + e);
                }
            }
        }
    }
}
