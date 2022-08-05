package com.SchildtBeginnersGuide.randomtasks.bookpackextended;
import com.SchildtBeginnersGuide.randomtasks.bookpack.Book;

class BookExt extends Book {

    private final String author;

    BookExt(String title, int pages, String author) {
        super(title, pages);
        this.author = author;
    }

    protected String getAuthor() {
        return author;
    }
}

public class BookManager {
    public static void main(String[] args) {
        BookExt book = new BookExt("Kniga1", 100, "Ya");
        System.out.println(book.title);
        System.out.println(book.getAuthor());
    }
}