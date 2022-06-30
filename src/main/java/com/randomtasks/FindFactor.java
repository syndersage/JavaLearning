package com.randomtasks;

public class FindFactor {
    public static void main(String[] args) {
        for (int i = 2; i < 100; i++) {
            System.out.print(i + " dividors is:");
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) System.out.print(" " + j);
            }
            for (int j = (int) Math.sqrt(i); j >= 2; j--) {
                if (i % j == 0) System.out.print(" " + i / j);
            }
            System.out.println();
        }
    }
}
