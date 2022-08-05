package com.SchildtBeginnersGuide.randomtasks;

import java.io.IOException;

public class LetterGuess {
    public static void main(String[] args) throws IOException {
        char ch, ignore, answer = 'k';
        do {
            System.out.print("Enter the letter i made wish for: ");
            ch = (char) System.in.read();
            do {
                ignore = (char) System.in.read();
            } while (ignore != '\n');
            if (answer == ch) System.out.println("***RIGHT***");
            else {
                System.out.print("wrong, ");
                if (ch < answer) System.out.println("answer is higher");
                else System.out.println("answer is lower");
            }
        } while (ch != answer);
    }
}
