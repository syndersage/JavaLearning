package com.SchildtBeginnersGuide.trythis.c01.t12;

import java.util.Scanner;

public class GalToLitTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input first value of interval: ");
        int left = 1, right = 2;
        if (scan.hasNextInt()) {
            left = scan.nextInt();
        } else {
            scan.next();
        }
        System.out.print("Input last value of interval: ");
        if (scan.hasNextInt()) {
            right = scan.nextInt();
        }
        for (int i = left; i < right; i++) {
            System.out.println(i + " gallons is " + i * 3.7854 + " litters");
        }
        scan.close();
    }
}
