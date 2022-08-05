package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s06.t03;

import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        var stack = new Stack(new long[] {15, 33, 5435234, -15}, 5);
        while (true) {
            int choice;
            StackMenu.showClauses();
            while (!scan.hasNextInt()) {
                System.out.println("Incorrect input!");
                StackMenu.showClauses();
                scan.next();
            }
            choice = scan.nextInt();
            if (choice == 0) {
                System.out.println("Quiting...");
                break;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter integer value to add in stack: ");
                    while (!scan.hasNextLong()) {
                        System.out.print("Enter integer value to add in stack: ");
                        scan.next();
                    }
                    stack.push(scan.nextLong());
                }
                case 2 -> {
                    long stackValue = stack.pop();
                    System.out.print(stack.isValidPop() ? "Popped value from stack: " + stackValue + "\n" : "");
                }
                default -> System.out.println("Incorrect menu item!");
            }
        }
    }
}

class Stack {
    private final long[] stack;
    private int stackIndex;
    private boolean valid = true;

    Stack(int stackSize) {
        if (stackSize < 1) stackSize = 10;
        this.stackIndex = 0;
        this.stack = new long[stackSize];
    }

    Stack(long[] stack) { this(stack, stack.length); }

    Stack(long[] stack, int stackSize) {
        this.stackIndex = stack.length;
        this.stack = new long[stackSize];
        System.arraycopy(stack, 0, this.stack, 0, stack.length);
    }

     public void push(long value) {
        if (stackIndex == stack.length) System.out.println("Stack is full!");
        else {
            stack[stackIndex++] = value;
            System.out.println("Value successfully pushed!");
        }
    }

    public long pop() {
        if (stackIndex == 0) {
            System.out.println("Stack is empty!");
            valid = false;
            return -1;
        } else {
            valid = true;
            return stack[--stackIndex];
        }
    }

    public boolean isValidPop() { return valid; }
}

class StackMenu {
    static void showClauses() {
        System.out.print("""
                What to do with stack:
                \t1. Push
                \t2. Pop
                Choose one (0 to quit):\s""");
    }

    static boolean isValidClause(int clause) { return clause >= 0 && clause <= 2; }
}
