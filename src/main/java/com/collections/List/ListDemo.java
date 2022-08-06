package com.collections.List;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1, 1);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        List<String> strings = List.of("H", "E", "L", "L", "O");
        System.out.println(strings.get(1));
        for (String string : strings) {
            System.out.println(string);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            System.out.println(set.add(i));
        }
        System.out.println(set.add(5));
        System.out.println(set.remove(1));
        System.out.println(set.remove(1));
        System.out.println(Arrays.toString(set.toArray()));
        NavigableSet<Integer> navSet = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            System.out.println(navSet.add(i + 10));
        }
        System.out.println(navSet.headSet(12));
        System.out.println(navSet.ceiling(100));
        System.out.println(navSet.higher(100));
        System.out.println(navSet.pollLast());
        for (Integer integer : navSet) {
            System.out.print(integer.toString() + " ");
        }
        Collection<Integer> collection = new ArrayList<>();
        Queue<Integer> integerQueue = new PriorityQueue<>();
        integerQueue.add(10);
        integerQueue.add(15);
        integerQueue.add(15);
        integerQueue.add(20);
        System.out.println();
        System.out.println(integerQueue.poll());
        System.out.println(integerQueue.remove(15));
        System.out.println(integerQueue.peek());
        System.out.println(integerQueue);
    }
}
