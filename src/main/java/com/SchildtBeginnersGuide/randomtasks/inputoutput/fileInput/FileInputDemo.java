package com.SchildtBeginnersGuide.randomtasks.inputoutput.fileInput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputDemo {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            file = new FileInputStream("F:\\JavaTest\\File.txt");
            if (file != null) {
                byte[] arr;
                arr = file.readAllBytes();
                System.out.println(Arrays.toString(arr));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println("Some reading issue");
        }
        finally {
            try {
                file.close();
            }
            catch (NullPointerException e) {
                System.out.println(e);
            }
            catch (IOException e) {
                System.out.println("Cannot close file: " + file);
            }
        }
    }
}
