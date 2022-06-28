package com.randomtasks;

import java.io.IOException;

public class LetterGuess {
    public static void main(String[] args) throws IOException {
        char ch, answer = 'k';
        System.out.print("Enter the letter i made wish for: ");
        if (answer == (ch = (char) System.in.read())) System.out.println("***RIGHT***");
        else {
            System.out.print("wrong, ");
            if (ch < answer) System.out.println("answer is higher");
            else System.out.println("answer is lower");
        }
    }
}
