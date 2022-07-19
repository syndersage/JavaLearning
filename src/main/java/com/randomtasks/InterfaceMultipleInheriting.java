package com.randomtasks;

interface TestA {
    default void meth() {
        System.out.println("A");
    }
    static void statMeth() {
        System.out.println("Static method");
    }
}

interface TestB extends TestA {
    default void meth() {
        System.out.println("B");
    }

    private void privateMeth() {
        System.out.println("HEHE");
    }
}

interface TestC extends TestB {
    default void meth() {
        TestB.super.meth();
    }
}

class TestAB implements TestA, TestB {
    public void meth() {
    }
}

public class InterfaceMultipleInheriting {
    public static void main(String[] args) {
        TestA obj = new TestAB();
        obj.meth();
    }
}
