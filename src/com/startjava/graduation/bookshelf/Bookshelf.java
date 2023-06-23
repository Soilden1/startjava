package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int CAPACITY = 10;
    private static final int INFO_CAPACITY = 3;
    private final Book[] books = new Book[CAPACITY];
    private int countBooks;
    public int shelfLength;

    public int getCountBooks() {
        return countBooks;
    }

    public int getFreeShelves() {
        return CAPACITY - countBooks;
    }

    public int getShelfLength() {
        return shelfLength;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, countBooks);
    }

    public Book getBook(String title) {
        int place = findPlace(title);
        return (place >= 0 ? books[place] : null);
    }

    public void add(String inputBookInfo) {
        String[] bookInfo = inputBookInfo.split(", ");
        if (countBooks >= CAPACITY) {
            System.out.println("Ошибка: в шкафу закончились свободные полки");
        } else if (bookInfo.length == INFO_CAPACITY) {
            try {
                Book book = new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]));
                books[countBooks++] = book;
                increaseLength(inputBookInfo.length());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: невалидный формат");
            }
        } else {
            System.out.println("Ошибка: необходимо вводить данные в формате: 'Имя автора, название книги, год издания'");
        }
    }

    public void delete(String title) {
        int place = findPlace(title);
        if (place < 0) {
            System.out.println("Ошибка: книга не найдена");
        } else {
            int length = books[place].getLength();
            System.arraycopy(books, place + 1, books, place, countBooks-- - place - 1);
            if (length == shelfLength) {
                calculateLength();
            }
        }
    }

    public void clear() {
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
        shelfLength = 0;
    }

    private int findPlace(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    private void calculateLength() {
        shelfLength = 0;
        for (int i = 0; i < countBooks; i++) {
            increaseLength(books[i].getLength());
        }
    }

    private void increaseLength(int length) {
        if (length > shelfLength) {
            shelfLength = length;
        }
    }
}