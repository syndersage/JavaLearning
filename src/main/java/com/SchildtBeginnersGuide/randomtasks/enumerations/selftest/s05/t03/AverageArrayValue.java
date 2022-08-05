package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s05.t03;


public class AverageArrayValue {
    public static void main(String[] args) {
        double[] arr = {1, 5, 100, 22, 15, 0.5, -11.78, -765, 105.6, -55.565439104};
        double average = 0;
        for (var elem : arr) average += elem;
        average /= arr.length;
        System.out.println(average);
    }
}
