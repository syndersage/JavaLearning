package com.collections.Map;

import com.sun.source.tree.BreakTree;

import java.util.*;

class Book {
    private final String author;
    private final int pages;
    Book(String author, int pages) {
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }
}

public class TreeMapDemo {
    public static void main(String[] args) {
        //Comparator<Book> comparator = (o1, o2) -> o2.getPages() - o1.getPages();
        //comparator = comparator.reversed();
        Map<Book, String> integerStringMap = new TreeMap<>(Comparator.comparingInt(Book::getPages).thenComparing(Comparator.comparing(Book::getAuthor).reversed()));

        integerStringMap.put(new Book("Author1", 350), "OK");
        integerStringMap.put(new Book("Author2", 2000), "Good");
        integerStringMap.put(new Book("Author2", 350), "Bad");
        var it = integerStringMap.entrySet();
        for (Map.Entry<Book, String> entry : it) {
            System.out.println(entry.getKey().getAuthor() + " " + entry.getKey().getPages() + " " + entry.getValue());
        }
    }
}
