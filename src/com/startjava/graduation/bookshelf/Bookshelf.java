package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int countBooks;

    public void add(String inputBook) throws IndexOutOfBoundsException {
        if (countBooks >= CAPACITY) {
            System.out.println("Ошибка: в шкафу закончились свободные полки");
        } else {
            String[] string = inputBook.split(", ");
            Book book = new Book(string[0], string[1], Integer.parseInt(string[2]));
            books[countBooks++] = book;
        }
    }

    public int find(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(String title) {
        int bookPlace = find(title);
        System.arraycopy(books, bookPlace + 1, books, bookPlace, countBooks - bookPlace - 1);
        countBooks--;
    }

    public Book getBook(String title) {
        return books[find(title)];
    }

    public void clear() {
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public int getCountBooks() {
        return countBooks;
    }

    public int getFreeShelves() {
        return CAPACITY - countBooks;
    }
}