package com.selftest.s03.t10;

import java.io.IOException;

public class LowercaseUppercase {
    public static void main(String[] args) throws IOException {
        char ch;
        int counter = 0;
        while (true) {
            System.out.print("Enter some text (period to quit): ");
            ch = (char) System.in.read();
            if (ch == '.') break;
            if (ch != '\n') {
                do {
                    if (ch >= 97 && ch <= 122) {
                        ch -= 32;
                        counter++;
                    } else if (ch >= 65 && ch <= 90) {
                        ch += 32;
                        counter++;
                    }
                    System.out.print(ch);
                    ch = (char) System.in.read();
                } while (ch != '\n');
                System.out.println();
            }
        }
        System.out.println("\n" + counter + " symbols changed");
    }
}
