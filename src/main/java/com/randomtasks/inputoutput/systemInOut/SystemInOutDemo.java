package com.randomtasks.inputoutput.systemInOut;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class SystemInOutDemo {
    public static void main(String[] args) throws IOException {
        byte[] arr = new byte[10];
        System.in.read(arr, 3, 5);
        for (byte ch:
             arr) {
            System.out.print((char) ch);
        }
        System.out.println(10);
    }
}
