package com.randomtasks;

class A {
    int a;
    public void showA() {
        System.out.println(a);
    }
}

class B extends A {
    int a = 10;
    public void showA() {
        System.out.println(a);
        super.showA();
    }
}

public class OverridingTest {
    public static void main(String[] args) {
        var test = new B();
        test.showA();
    }
}
