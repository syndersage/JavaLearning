package com.trythis.c06.t03;

import java.util.Arrays;

class Quicksort {
    public static void quicksort(int[] arr) {
        sorting(arr, 0, arr.length - 1);
    }

    private static void sorting(int[] arr, int left, int right) {
        int i = left, j = right;
        int splitValue = arr[(right + left) / 2];
        while (i < j) {
            if (arr[i] < splitValue) i++;
            if (arr[j] > splitValue) j--;
            if (arr[i] > arr[j]) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        if (i > left) sorting(arr, left, j);
        if (right > j) sorting(arr, j + 1, right);
    }
}

public class QuicksortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {27, 40, 7, 44, 8, 38, 11, 26};
        System.out.println(Arrays.toString(arr));
        Quicksort.quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
