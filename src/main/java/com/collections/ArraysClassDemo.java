package com.collections;

import java.util.Arrays;

public class ArraysClassDemo {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));
        arr = Arrays.copyOf(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
