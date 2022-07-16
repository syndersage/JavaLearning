package com.randomtasks.inputoutput.fileOutput;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOutputDemo {
    public static void main(String[] args) throws FileNotFoundException {
        final FileOutputStream file = new FileOutputStream("F:\\JavaTest\\Fil4e.txt", true);
        try (file; FileOutputStream fileOutputStream = new FileOutputStream("F:\\JavaTest\\Fil4e.txt", true)) {
            System.in.read();
            fileOutputStream.write(100);
            byte[] arr = {69, 70, 71};
            if (file != null) {
                file.write(arr, 1, 2);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
        }
        catch (IOException e) {
            System.out.println(e);
        }
        finally {
            try {
                file.close();
            }
            catch (IOException e) {
                System.out.println("Cannot close file");
            }
        }
        System.out.println("END");
    }
}
