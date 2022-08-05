package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s14.t08;

interface MyFunc<T> {
    T func(T t);
}

interface MyConstructor<T> {
    MyClass<T>[] init();
}

class MyClass<T> {

}

public class GenericNumericDemo {
    public static void main(String[] args) {
        int a = 10;
        MyFunc<Integer> func = integer -> {
            int factorial = 1 + a;
            for (int i = 2; i <= integer; i++) {
                factorial *= i;
            }
            return factorial;
        };
        System.out.println(func.func(5));
    }
}
