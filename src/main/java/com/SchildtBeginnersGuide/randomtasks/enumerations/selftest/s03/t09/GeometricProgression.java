package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s03.t09;

public class GeometricProgression {
    public static void main(String[] args) {
        int result = 1;
        while (true) {
            result += result;
            if (result > 10000) break;
            System.out.println(result);
        }
    }
}
