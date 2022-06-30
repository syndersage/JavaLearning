package com.selftest.s03.t01;

import java.io.IOException;

public class SpacesCounter {
    public static void main(String[] args) throws IOException {
        int spacesCounter = 0;
        char ch;
        do {
            ch = (char) System.in.read();
            if (ch == ' ') spacesCounter++;
        } while (ch != '.');
        while (ch != '\n') {
            ch = (char) System.in.read();
        }
        System.out.println("You entered " + spacesCounter + " spaces");
    }
}
