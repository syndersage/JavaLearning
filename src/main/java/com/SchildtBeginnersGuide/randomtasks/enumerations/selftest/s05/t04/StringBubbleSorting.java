package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s05.t04;

import java.util.Arrays;

public class StringBubbleSorting {
    public static void main(String[] args) {
        String[] strings = {"Hello", "World", "qwee", "1`2341", "NewLine", "\s\t\n"};
        int size = strings.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (strings[i].compareToIgnoreCase(strings[j]) > 0) {
                    var temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(strings));
    }
}
