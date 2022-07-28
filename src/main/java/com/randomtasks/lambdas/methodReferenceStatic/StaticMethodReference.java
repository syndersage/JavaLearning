package com.randomtasks.lambdas.methodReferenceStatic;

import java.util.Scanner;

interface IntPredicate {
    boolean test(int value);
}

class MyIntPredicates {
    static boolean isEven(int value) {
        return value % 2 == 0;
    }

    static boolean isPositive(int value) {
        return value > 0;
    }

    boolean isPrime(int value) {
        if (value <= 3) return true;
        for (int i = 2; i <= value / i; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}

public class StaticMethodReference {

    static boolean intTester(IntPredicate test, int value) {
        return test.test(value);
    }

    public static void main(String[] args) {
        MyIntPredicates predicates = new MyIntPredicates();
        System.out.println(intTester(predicates::isPrime, new Scanner(System.in).nextInt()));
    }
}
