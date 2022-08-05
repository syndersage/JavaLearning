package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s10.t08;

import java.io.*;

public class TextFileCopyingDemo2 {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(System.out, true);
        DataInputStream readFile = null;
        DataOutputStream writeFile = null;
        try {
            readFile = new DataInputStream(new FileInputStream("src\\main\\java\\com\\selftest\\s10\\t07\\file1"));
            writeFile = new DataOutputStream(new FileOutputStream("src\\main\\java\\com\\selftest\\s10\\t07\\file2"));
            if (writeFile != null && readFile != null) {
                int symbol;
                do {
                    symbol = readFile.read();
                    if (symbol != -1 && symbol != ' ') writeFile.write(symbol);
                    else if (symbol == ' ') writeFile.write('-');
                } while (symbol != -1);
            }
        }
        catch (FileNotFoundException e) {
            writer.println("File not found");
        }
        catch (IOException e) {
            writer.println(e);
        }
        finally {
            if (readFile != null) readFile.close();
            if (writeFile != null) writeFile.close();
        }
    }
}
