package com.startjava.graduation.bookshelf;

import java.util.Arrays;
import java.util.Scanner;

public class Bookshelf {

    public static final int CAPACITY = 10;
    private final Book[] books = new Book[CAPACITY];
    private int countBooks;

    public void add() throws IndexOutOfBoundsException {
        if (countBooks >= CAPACITY) {
            System.out.println("Ошибка: в шкафу закончились свободные полки");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите книгу в формате 'Имя автора, название книги, год издания'");

            String[] string = sc.nextLine().split(", ");
            Book book = new Book(string[0], string[1], Integer.parseInt(string[2]));
            books[countBooks++] = book;
        }
    }

    public int find() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        String title = sc.nextLine();

        for (int i = 0; i < countBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int bookPlace) {
        if (bookPlace >= 0) {
            System.arraycopy(books, bookPlace + 1, books, bookPlace, countBooks - bookPlace - 1);
            countBooks--;
        } else {
            System.out.println("Ошибка: книга не найдена");
        }
    }

    public Book getBook(int place) {
        return books[place];
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