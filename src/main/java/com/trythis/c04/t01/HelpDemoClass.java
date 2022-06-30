package com.trythis.c04.t01;


import java.io.IOException;

class Help {
    void showMenu() {
        System.out.print("""
                                        
                Help on:
                \t1. if
                \t2. switch
                \t3. for
                \t4. while
                \t5. do-while
                \t6. break
                \t7. continue
                Choose one (press 'q' to exit):\s""");
    }

    void chosenClause(char clause) {
        switch (clause) {
            case '1' -> System.out.print("""
                                            
                    The if:
                    if (conditional) statement
                    else statement
                    """);
            case '2' -> System.out.print("""

                    The switch:

                    switch (expression) {
                    \tcase constant:
                    \t\tstatement sequence
                    \t\tbreak;
                    \t//...}
                    """);
            case '3' -> System.out.print("""
                                        
                    The for:
                    for (init; condition; iteration)
                    \tstatement;
                    """);
            case '4' -> System.out.print("""
                                        
                    The while:
                    while (condition) statement;
                    """);
            case '5' -> System.out.print("""
                                        
                    The do-while:
                    do {
                    \tstatement;
                    } while (condition);
                    """);
            case '6' -> System.out.print("""
                                        
                    The break:
                    break; or break label;
                    """);
            case '7' -> System.out.print("""
                                        
                    The continue:
                    continue; or continue label;
                    """);
            default -> System.out.println("\nSelection not found");
        }
    }

    boolean validClause(char clause) {
        return (clause >= '1' && clause <= '7') || clause == 'q';
    }
}


class HelpDemoClass {
    public static void main(String[] args) throws IOException {
        Help help = new Help();
        char choice;
        while (true) {
            do {
                help.showMenu();
                choice = (char) System.in.read();
                char ignore;
                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (!help.validClause(choice));
            if (choice == 'q') break;
            help.chosenClause(choice);
        }
    }
}
