package com.randomtasks;

import java.io.IOException;

public class LetterGuess {
    public static void main(String[] args) throws IOException {
        char ch, answer = 'k';
        do {
            System.out.print("Enter the letter i made wish for: ");
            do {
                ch = (char) System.in.read();
            } while (ch == '\n');
            if (answer == ch) System.out.println("***RIGHT***");
            else {
                System.out.print("wrong, ");
                if (ch < answer) System.out.println("answer is higher");
                else System.out.println("answer is lower");
            }
        } while (ch != answer);
    }
}
