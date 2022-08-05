package com.SchildtBeginnersGuide.randomtasks.lambdas.predefinedInterfaces;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class PredefinedInterfaces {
    public static void main(String[] args) {
        UnaryOperator<Integer> operator1 = val -> val * 2;
        System.out.println(operator1.apply(10));
        BinaryOperator<Double> operator2 = (val1, val2) -> {
            val1 = val2 * val1;
            val1 = Math.sqrt(val1);
            return val1;
        };
        System.out.println(operator2.apply(10.0, 15.0));
        Predicate<Boolean> operator3 = (val) -> !val;
        System.out.println(operator3.test(false));
    }
}
