package com.SchildtBeginnersGuide.trythis.c10.t02;

import java.io.*;

class Helper {
    String helpFile;
    Helper(String helpFile) {
        this.helpFile = helpFile;
    }

    final boolean getHelp(String requestedTopic) {
        try (BufferedReader file = new BufferedReader(new FileReader(helpFile))) {
            PrintWriter writer = new PrintWriter(System.out, true);
            int currentSymbol;
            do {
                do {
                    currentSymbol = file.read();
                } while ((char) currentSymbol != '#' && currentSymbol != -1);
                if (currentSymbol == -1) {
                    return false;
                }
            } while (!requestedTopic.equals(file.readLine()));
            String outputtingHelp;
            do {
                outputtingHelp = file.readLine();
                if (outputtingHelp != null && !outputtingHelp.equals("")) writer.println(outputtingHelp);
            } while (outputtingHelp != null && !outputtingHelp.equals(""));
            return true;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
        return false;
    }

    int showTopics() {
        try (BufferedReader file = new BufferedReader(new FileReader(helpFile))) {
            PrintWriter writer = new PrintWriter(System.out, true);
            int currentSymbol;
            int numOfTopics = 0;
            while (true) {
                do {
                    currentSymbol = file.read();
                } while (currentSymbol != -1 && (char) currentSymbol != '#');
                if (currentSymbol == -1) return numOfTopics;
                writer.println(file.readLine());
                numOfTopics++;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return 0;
    }
}

public class FileHelpDemo {
    public static void main(String[] args) {
        Helper helper = new Helper("src\\main\\java\\com\\trythis\\c10\\t02\\file1");
//        helper.showTopics();
//        helper.getHelp("help");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);
        try {
            int item = -1;
            do {
                do {
                    pw.print("1.List topics\n2.Get info\nChoose one (0 to quit): ");
                    pw.flush();
                    try {
                        item = Integer.parseInt(br.readLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect input: " + e);
                    }
                } while (item > 2 || item < 0);
                if (item == 0) return;
                switch (item) {
                    case 1 -> helper.showTopics();
                    case 2 -> {
                        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                        pw.print("Enter topic name: ");
                        pw.flush();
                        helper.getHelp(br2.readLine());
                    }
                    default -> pw.println("Incorrect menu item!");
                }
            } while (true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
