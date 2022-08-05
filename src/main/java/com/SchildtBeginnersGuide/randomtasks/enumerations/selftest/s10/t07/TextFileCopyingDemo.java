package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s10.t07;

import java.io.*;

public class TextFileCopyingDemo {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out, true);
        try (BufferedReader readFile = new BufferedReader(new FileReader("src\\main\\java\\com\\selftest\\s10\\t07\\file1"));
             FileWriter writeFile = new FileWriter("src\\main\\java\\com\\selftest\\s10\\t07\\file2")) {
            int symbol;
            do {
                symbol = readFile.read();
                if (symbol != -1 && symbol != ' ') writeFile.write(symbol);
                else if (symbol == ' ') writeFile.write('-');
            } while (symbol != -1);
        }
        catch (FileNotFoundException e) {
            writer.println("File not found");
        }
        catch (IOException e) {
            writer.println(e);
        }
    }
}
