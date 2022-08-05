package com.SchildtBeginnersGuide.randomtasks;

class StaticTest {
    static int x;
    int y;

    static void setter(StaticTest obj, int z) {
        StaticTest.x = obj.y + z;
    }
}

public class StaticMembers {
    public static void main(String[] args) {
        StaticTest test1 = new StaticTest();
        test1.y = 10;
        StaticTest.setter(test1, 15);
        System.out.println(StaticTest.x);
        int[] arr = new int[5];

    }
}
