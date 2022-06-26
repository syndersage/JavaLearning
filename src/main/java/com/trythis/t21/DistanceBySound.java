package com.trythis.t21;

import java.util.Scanner;

public class DistanceBySound {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter time between you saw and heard (in seconds): ");
        if (scan.hasNextDouble()) {
            System.out.println("The object in distant of " + scan.nextInt() * 335 + " meters");
        }
        scan.close();
    }
}
