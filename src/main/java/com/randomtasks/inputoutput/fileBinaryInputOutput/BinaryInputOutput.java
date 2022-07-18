package com.randomtasks.inputoutput.fileBinaryInputOutput;


import java.io.*;
import java.util.Arrays;

public class BinaryInputOutput {
    public static void main(String[] args) {
        try (DataInputStream file1 = new DataInputStream(new FileInputStream("F:\\JavaTest\\File1.txt"));
                DataInputStream file2 = new DataInputStream(new FileInputStream("F:\\JavaTest\\File2.txt"))) {
            for (int i = 0; i < 5; i++) {
                System.out.println(file1.read());
            }
        }
        catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
