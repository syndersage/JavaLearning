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
        byte b3 = 10;
        l = (byte) (b3 + b3);
        System.out.println(((Object) l).getClass().getSimpleName());
        char ch2 = 129;
        System.out.println((short) ch2);
        int i1 = 10, i2 = 3;
        System.out.println((double) (i1 / 3));
        for (int j = 0; j < 5; j++) {
            System.out.println(j + " " + (double) (j / 3));
        }
        double d2 = 50;
        //d2 = (int) (d2 + 5.5);
        System.out.println(((Object) ((int) d2 + 5.5)).getClass().getSimpleName());
        int a = (int) d2++;
        System.out.println(a + " " + d2);
        int x = 10, y = 3;
        double result = 10 / (double) 3;
        System.out.println(result);
    }
}
