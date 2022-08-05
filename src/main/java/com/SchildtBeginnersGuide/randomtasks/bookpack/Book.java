package com.SchildtBeginnersGuide.randomtasks.bookpack;

public class Book {
    public final String title;
    protected final int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public final void show() {
        System.out.println(title);
    }
}
