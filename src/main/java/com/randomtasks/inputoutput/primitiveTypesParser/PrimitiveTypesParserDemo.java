package com.randomtasks.inputoutput.primitiveTypesParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrimitiveTypesParserDemo {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int read = -1;
            Integer val = 10;
            System.out.println(val.equals(10));
            do {
                try {
                    read = Integer.parseInt(br.readLine());
                    System.out.println("Parsed: " + read);
                }
                catch (NumberFormatException e) {
                    throw new IOException("Incorrect parsing of integer", e);
                }
            } while (read != -1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
