package com.collections.CollectionsClass;

import java.util.*;

public class CollectionsClassDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);
        integerList.add(40);
        Collections.addAll(integerList, 50, 60, 70, 80);
        //integerList.remove(1);
        //Collections.rotate(integerList, 1);
        Collections.shuffle(integerList);
        Collections.swap(integerList, 0, 3);
        System.out.println(Collections.min(integerList));
        System.out.println(integerList);
        System.out.println(Collections.disjoint(integerList, Collections.singletonList(10)));
    }
}
