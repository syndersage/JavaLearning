package com.randomtasks.inputoutput.writerForFiles;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriterForFilesDemo {
    public static void main(String[] args) {
        try (FileWriter file = new FileWriter("F:\\JavaTest\\file1.txt", false);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String inp = "";
            while (!inp.equals("STOP")) {
                inp = console.readLine();
                if (!inp.equals("STOP")) file.write(inp + "\r\n");
            }
        }
        catch (IOException exception) {
            System.out.println(exception);
        }
        finally {
            System.out.println("Stopped.");
        }
    }
}
