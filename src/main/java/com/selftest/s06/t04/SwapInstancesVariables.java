package com.selftest.s06.t04;

public class SwapInstancesVariables {
    private int a;
    private void swap(SwapInstancesVariables obj) {
        int temp = obj.a;
        obj.a = this.a;
        this.a = temp;
    }

    SwapInstancesVariables(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        var obj1 = new SwapInstancesVariables(10);
        var obj2 = new SwapInstancesVariables(20);
        System.out.println("Object1 variable equals " + obj1.a + "; Object2 variable equals " + obj2.a);
        obj1.swap(obj2);
        System.out.println("Object1 variable equals " + obj1.a + "; Object2 variable equals " + obj2.a);
    }
}
