package com.selftest.s01.t09;

import java.util.Scanner;

public class MoonGravity {
    public static void main(String[] args) {
        System.out.print("Input your weight on Earth: ");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            int weight = scan.nextInt();
            System.out.println("Your weight on Moon is: " + weight * 0.17);
        }
        scan.close();
    }
}
