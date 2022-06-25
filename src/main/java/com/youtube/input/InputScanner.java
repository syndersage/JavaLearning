package com.youtube.input;

import java.util.Scanner;

public class InputScanner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Input integer: ");
        while (!s.hasNextInt()) {
            s.next();
            System.out.print("Input integer: ");
        }
        System.out.println("Entered integer is: " + s.nextInt());
        s.close();
    }
}
