package com.youtube.input;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StringScanner {
    public static void main(String[] args) {
        String str = "Hel\nlo world!!!";
        Scanner scan = new Scanner(str);

        System.out.println(scan.delimiter());
        scan.useDelimiter("\\p{javaWhitespace}");
        System.out.println(scan.delimiter());

        System.out.println("\n");
        while (scan.hasNext()) {
            System.out.println(scan.next());
        }
        scan.close();
    }
}
