package com.selftest.s06.t06;

public class RecursiveStringBackwards {
    private static void backward(String str) { backward(str, 0); }

    private static void backward(String str, int currentIndex) {
        if (currentIndex == str.length() - 1) System.out.print(str.charAt(currentIndex));
        else {
            backward(str, currentIndex + 1);
            System.out.print(str.charAt(currentIndex));
        }
    }

    public static void main(String[] args) {
        String str = "Some random string to display it backwards";
        RecursiveStringBackwards.backward(str);
    }
}
