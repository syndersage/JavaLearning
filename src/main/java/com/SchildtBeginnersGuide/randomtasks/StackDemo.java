package com.SchildtBeginnersGuide.randomtasks;

import java.util.Scanner;

class Stack {
    int[] arr;
    int stackIndex;

    void put(int value) {
        if (stackIndex == arr.length) {
            System.out.println("Stack is full. Putting value ignored");
            return;
        }
        arr[stackIndex++] = value;
    }

    int get() {
        if (stackIndex == 0) {
            System.out.println("Stack is empty!");
            return 0;
        }
        return arr[--stackIndex];
    }

    Stack(int stackSize) {
        arr = new int[stackSize];
        stackIndex = 0;
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        int choice;
        Scanner scan = new Scanner(System.in);
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
                    System.out.print("Enter value to add in stack: ");
                    stack.put(scan.nextInt());
                }
                case 2 -> {
                    int valueFromStack = stack.get();
                    System.out.println("Last value in stack is: " + valueFromStack);
                }
                default -> System.out.println("Incorrect clause");
            }
        }
    }
}
