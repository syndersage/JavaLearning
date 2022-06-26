package com.randomtasks;

import java.util.Scanner;

public class Hypotenuse {
    public static void main(String[] args) {
        double x, y;
        Scanner scan = new Scanner(System.in);
        System.out.print("X: ");
        x = scan.nextInt();
        System.out.print("Y: ");
        y = scan.nextInt();
        System.out.println("Z: " + Math.sqrt(x * x + y * y));
        scan.close();
    }
}
