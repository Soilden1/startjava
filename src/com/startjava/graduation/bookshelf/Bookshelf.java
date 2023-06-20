package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {

    public static final int CAPACITY = 3;
    private final Book[] books = new Book[CAPACITY];
    private int countBooks;
    public int shelfLength;

    public void add(String inputBookInfo) {
        String[] bookInfo = inputBookInfo.split(", ");

        if (countBooks >= CAPACITY) {
            System.out.println("Ошибка: в шкафу закончились свободные полки");
        } else if (bookInfo.length == 3) {
            try {
                Book book = new Book(bookInfo[0], bookInfo[1], Integer.parseInt(bookInfo[2]));
                books[countBooks++] = book;

                int length = inputBookInfo.length();
                if (length > shelfLength) {
                    shelfLength = length;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: невалидный формат");
            }
        } else {
            System.out.println("Ошибка: необходимо ввести три пункта");
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
        if (bookPlace < 0) {
            System.out.println("Ошибка: книга не найдена");
        } else {
            int length = books[bookPlace].getLength();
            System.arraycopy(books, bookPlace + 1, books, bookPlace, countBooks - bookPlace - 1);
            countBooks--;

            if (length == shelfLength) {
                calculateLength();
            }
        }
    }

    public Book getBook(String title) {
        return books[find(title)];
    }

    public void clear() {
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
        shelfLength = 0;
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

    public int getShelfLength() {
        return shelfLength;
    }

    private void calculateLength() {
        shelfLength = 0;
        for (int i = 0; i < countBooks; i++) {
            int length = books[i].getLength();
            if (length > shelfLength) {
                shelfLength = length;
            }
        }
    }
}