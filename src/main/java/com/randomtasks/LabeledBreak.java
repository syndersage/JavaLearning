package com.randomtasks;

import java.io.IOException;

public class LabeledBreak {
    public static void main(String[] args) throws IOException {
        findSmth: {
            if ('q' == (char) System.in.read()) break findSmth;
            System.out.println("hehe");
        }
    }
}
