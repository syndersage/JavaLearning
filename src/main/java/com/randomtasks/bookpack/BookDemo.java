package com.randomtasks.bookpack;

public class BookDemo {
    public static void main(String[] args) {
        var books = new Book[3];
        books[0] = new Book("Hello");
        books[1] = new Book("World");
        books[2] = new Book("!");
        for (var book : books) {
            book.show();
        }
    }
}

class Book {
    private final String title;

    Book(String title) {
        this.title = title;
    }

    public final void show() {
        System.out.println(title);
    }
}
