package com.randomtasks.generics.boundedTypes;

import java.util.Objects;

class GenericTest<T extends Number> {
    T number;
    GenericTest(T number) {
        this.number = number;
    }
    boolean compareWith(A<? extends Number> gen) {
        return Math.abs(number.doubleValue()) == Math.abs(gen.obj.doubleValue());
    }

    boolean compareWith(GenericTest<? super Integer> gen) {
        return Math.abs(number.doubleValue()) == Math.abs(gen.number.doubleValue());
    }
}

class A<T> {
    final T obj;

    A(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    static <V extends Comparable<Integer>, E> boolean comp(V arr1, E[] arr2) {
        return true;
    }
}

class NonGeneric {
    Integer sum;
    <T extends Number> NonGeneric(T obj) {
        this.sum = 0;
        for (int i = 0; i < obj.intValue(); i++) {
            sum += i + 1;
        }
    }
    <T extends Integer> boolean compare(T obj) {
        return sum.equals(obj);
    }
}

public class BoundingTypesETC {
    public static void main(String[] args) {
        GenericTest<Integer> obj1 = new GenericTest<>(150);
        //GenericTest<Double> obj2 = new GenericTest<>(-150.0);
        System.out.println(obj1.compareWith(new A<Integer>(-150)));
        System.out.println(A.comp(5, new Integer[] {1, 5}));
        NonGeneric ng = new NonGeneric(5.5);
        System.out.println(ng.sum);
        System.out.println(ng.compare(15));
    }
}
