package com.selftest.s06.t13;

public class VarargsTest {
    private static int sum(int ... args) {
        int sum = 0;
        for (int i : args) sum += i;
        return sum;
    }

    private static int sum(int a, int ... args) {
        int sum = 0;
        for (int i : args) sum += i;
        return sum;
    }
    public static void main(String[] args) {
        ////System.out.println(sum(1, 5, 10, 99, 10000)); //ambiguous
    }
}
