package com.trythis.c13.t01;


import java.io.FileNotFoundException;

interface IQueue<T> {
    void push(T item) throws FullQueueException;
    T pop() throws EmptyQueueException;
}

class FullQueueException extends Exception {

}

class EmptyQueueException extends Exception {

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
            return queue[index--];
        }
        else throw new EmptyQueueException();
    }

    @Override
    public void push(T item) throws FullQueueException {
        if (index < queue.length - 1) {
            queue[++index] = item;
        }
        else throw new FullQueueException();
    }
}

public class GenericQueueDemo {
    public static void main(String[] args) {
        Double[] arr = {1.0, 5.0, 10.0, -0.09};
        Queue<Double> queue = new Queue<>(arr);
        try {
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            System.out.println(queue.pop());
            queue.push(100.0);
            System.out.println(queue.pop());
        }
        catch (FullQueueException | EmptyQueueException e) {
            System.out.println(e);
        }
    }
}
