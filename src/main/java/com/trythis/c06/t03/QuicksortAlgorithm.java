package com.trythis.c06.t03;

import java.util.Arrays;

class Quicksort {
    public static void quicksort(int[] arr) {
        sorting(arr, 0, arr.length - 1);
    }

    private static void sorting(int[] arr, int left, int right) {
        if (left < right) {
            int splitIndex = partition(arr, left, right);
            sorting(arr, left, splitIndex);
            sorting(arr, splitIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int splitValue = arr[(right + left) / 2];
        while (left < right) {
            if (arr[left] < splitValue) left++;
            if (arr[right] > splitValue) right--;
            if (arr[left] > arr[right]) swap(arr, left, right);
        }
        return right;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

public class QuicksortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3};
        System.out.println(Arrays.toString(arr));
        Quicksort.quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
