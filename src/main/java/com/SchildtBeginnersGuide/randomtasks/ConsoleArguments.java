package com.SchildtBeginnersGuide.randomtasks;

public class ConsoleArguments {
    public static void main(String[] args) {
        String[][] contactBook = {
                {"Ivan", "12345"},
                {"Boris", "00000"},
                {"Anna", "99511"}
        };
        if (args.length != 1) {
            System.out.println("Usage: java ConsoleArguments <name>");
            return;
        }
        boolean found = false;
        for (String[] contact : contactBook) {
            if (contact[0].equals(args[0])) {
                System.out.println(contact[0] + " number is: " + contact[1]);
                found = true;
                break;
            }
        }
        if (!found) System.out.println(args[0] + " phone number not found.");
    }
}
