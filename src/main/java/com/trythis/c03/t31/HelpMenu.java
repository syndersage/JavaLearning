package com.trythis.c03.t31;

import java.io.IOException;

public class HelpMenu {
    public static void main(String[] args) throws IOException {
        System.out.print("""
                Help on:
                \t1. if
                \t2. switch
                Choose one:\s""");
        char choice = (char) System.in.read();
        switch (choice) {
            case '1' -> System.out.println("""
                                            
                    The if:
                    if (conditional) statement
                    else statement""");
            case '2' -> System.out.println("""

                    The switch:

                    switch (expression) {
                    \tcase constant:
                    \t\tstatement sequence
                    \t\tbreak;
                    \t//...
                    }""");
            default -> System.out.println("\nSelection not found");
        }
    }
}
