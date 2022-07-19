package com.randomtasks.inputoutput.readerFromFiles;

import java.io.*;

public class ReaderFromFilesDemo {
    public static void main(String[] args) {
        try (BufferedReader file = new BufferedReader(new FileReader("F:\\JavaTest\\file1.txt"));
             PrintWriter console = new PrintWriter(System.out, true)) {
            String line = file.readLine();
            while (line != null) {
                console.println(line);
                line = file.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        }
        catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
    }
}
