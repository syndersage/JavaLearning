package com.SchildtBeginnersGuide.randomtasks.inputoutput.wrappedStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WrappedStreamsDemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            System.out.println(reader.skip(5));
            System.out.println(reader.readLine());
        }
        catch (IOException exception) {
            System.out.println(exception);
        }
    }
}
