package com.randomtasks;

import java.io.IOException;

public class KeyboardInput {
    public static void main(String[] args) throws IOException {
        char ch;
        System.out.print("Input a key followed by \"enter\": ");
        ch = (char) System.in.read();
        System.out.println("You intered " + ch + " symbol");
    }
}
