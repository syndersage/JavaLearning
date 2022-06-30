package com.trythis.c01.t11;

import java.util.Scanner;

public class GalToLit {
    public static void main(String[] args) {
        System.out.print("Input gallons as integer value: ");
        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.print("Input gallons as integer value: ");
        }
        double gallons = scan.nextInt();
        System.out.println(gallons + " gallons is " + gallons * 3.7854 + " litters");
        scan.close();
    }
}
