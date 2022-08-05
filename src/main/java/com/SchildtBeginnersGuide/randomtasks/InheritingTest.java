package com.SchildtBeginnersGuide.randomtasks;

class GeneralForInherit {
    private int a;
    private int b;

    public int multiply() {
        return a * b;
    }

    GeneralForInherit(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class InheritingTest extends GeneralForInherit {
    public static void main(String[] args) {
        var derive = new InheritingTest(10, 20);
        System.out.println(derive.str);
        var testB = new TestInheritB(15, 100);
        testB.showAFromB();
        testB.showAFromA();
    }
    String str;
    InheritingTest(int a, int b) {
        super(a, b);
        str = super.multiply() + " as string";
    }
}

class TestInheritA {
    int a;
    TestInheritA(int a) {
        this.a = a;
    }
    void showAFromA() {
        System.out.println(this.a);
    }
}

class TestInheritB extends TestInheritA {
    int a;
    TestInheritB(int a, int b) {
        super(a);
        this.a = b;
    }
    void showAFromB() {
        System.out.println(super.a);
    }
}
