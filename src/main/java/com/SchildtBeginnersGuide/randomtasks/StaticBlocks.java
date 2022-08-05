package com.SchildtBeginnersGuide.randomtasks;

class StaticBlock {
    static int a;

    public int getA() {
        return a;
    }

    static {
        StaticBlock.a = 10;
        System.out.println("HHE");
    }
}

public class StaticBlocks {
    public static void main(String[] args) {
        StaticBlock.a = 15;
    }
}
