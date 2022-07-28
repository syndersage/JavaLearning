package com.randomtasks.lambdas.methodReferenceInstance;

interface IntPredicate {
    boolean test(int value);
}

class MyIntValue {
    private final int value;

    public MyIntValue(int value) {
        this.value = value;
    }

    public boolean isFactor(int val2) {
        return value % val2 == 0;
    }

    public boolean isFactorWithTwo(IntPredicate ip, int val3) {
        return ip.test(value) && ip.test(val3);
    }
}

public class InstanceReferenceDemo {
    public static void main(String[] args) {
        MyIntValue value1 = new MyIntValue(120);
        MyIntValue value2 = new MyIntValue(60);
        IntPredicate predicate = value1::isFactor;
        System.out.println(value2.isFactorWithTwo(predicate, 40));
    }
}
