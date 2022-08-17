package com.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 1, 10));
        System.out.println(Arrays.toString(list.stream().mapToDouble(Double::valueOf).toArray()));
        int[] arr = list.stream().sorted().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));
        list.stream().sorted().forEach(System.out::println);
        System.out.println(list.stream().reduce((a, b) -> {
            System.out.println(a + " " + b);
            return a + b;
        }));
        list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.add(25);
        list.add(25);
        System.out.println(list);
        System.out.println(list.stream().skip(3).collect(Collectors.toList()));
        System.out.println(list.stream().distinct().collect(Collectors.toList()));
    }
}
