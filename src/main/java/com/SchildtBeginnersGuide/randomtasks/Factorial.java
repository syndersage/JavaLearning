package com.SchildtBeginnersGuide.randomtasks;

class Factor {
    long get_factorial_recursive(long a) {
        return a >= 0 ? a == 0 ? 1 : a * get_factorial_recursive(a - 1) : -1;
    }

    int get_factorial_recursive(int a) {
        if (a >= 0) return a == 0 ? 1 : a * get_factorial_recursive(a - 1);
        return -1;
    }

    int get_factorial_iterative(int a) {
        int result = -1;
        if (a >= 0) for (result = 1; a > 0; a--) result *= a;
        return result;
    }
}

public class Factorial {
    public static void main(String[] args) {
        Factor factor = new Factor();
        System.out.println(factor.get_factorial_recursive(5));
        System.out.println(factor.get_factorial_iterative(5));
    }
}
