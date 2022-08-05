package com.collections.CollectionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionInterfaceDemo {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        String str0 = "Hello2";
        collection.add(str0);
        Collection<String> collection2 = new ArrayList<>();
        String str = "Hello";
        collection.add(str);
        collection2.add("w");
        collection.addAll(collection2);
        collection2.clear();
        collection2.add("w");
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            //iterator.remove();
        }
        collection.remove(str);
        System.out.println(collection.contains("Hello2"));
        System.out.println(Arrays.toString(collection.toArray()));
        System.out.println(Arrays.toString(collection2.toArray()));
    }
}
