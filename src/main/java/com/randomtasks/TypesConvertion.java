package com.randomtasks;

public class TypesConvertion {
    public static void main(String[] args) {
        short l = 129;
        int i;
        i = l;
        byte b = 125;
        char ch = (char) b;
        System.out.println(ch);
        b = (byte) i;
        System.out.println(b);
        int d = (int) (13.6 / 3.0);
        System.out.println(d);
        byte b2 = (byte) 128;
        System.out.println(b2);
    }
}
