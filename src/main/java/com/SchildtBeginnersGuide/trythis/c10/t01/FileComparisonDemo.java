package com.SchildtBeginnersGuide.trythis.c10.t01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileComparisonDemo {
    public static void main(String[] args) {
        try (FileInputStream file1 = new FileInputStream("src/main/java/com/trythis/c10/t01/File1.txt");
             FileInputStream file2 = new FileInputStream("src/main/java/com/trythis/c10/t01/File2.txt")) {
            byte b1, b2;
            do {
                b1 = (byte) file1.read();
                b2 = (byte) file2.read();
                System.out.println("STEP");
            } while (b1 != -1 && b2 != -1);
            System.out.println(b1 == b2 ? "Files are the same!" : "Files are different!");
        } catch (FileNotFoundException e) {
            System.out.println("Cant find file!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
