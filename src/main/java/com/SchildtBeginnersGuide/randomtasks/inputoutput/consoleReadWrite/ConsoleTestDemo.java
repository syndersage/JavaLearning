package com.SchildtBeginnersGuide.randomtasks.inputoutput.consoleReadWrite;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleTestDemo {
    public static void main(String[] args) {
        if (System.console() != null) {
            System.out.print("Enter username: ");
            System.console().readLine();
            System.out.print("Enter password: ");
            char[] pass;
            pass = System.console().readPassword();
            System.out.println(pass);
        }
        else {
            System.out.println("Console is not available!");
        }
    }
}
