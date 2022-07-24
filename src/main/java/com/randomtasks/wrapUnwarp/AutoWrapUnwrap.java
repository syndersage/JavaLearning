package com.randomtasks.wrapUnwarp;

import java.lang.annotation.Inherited;

import static java.lang.Math.pow;


class InheritedAnnotation {
    int a;
}

class Derived extends InheritedAnnotation {
    int a;
}

public class AutoWrapUnwrap {

    private static int m1(Integer i) {
        return i;
    }

    private static Integer m2(int i) {
        return i;
    }

    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(m2(i));
        System.out.println(i = m1(15));
        System.out.println(pow(10, 5));
    }
}
