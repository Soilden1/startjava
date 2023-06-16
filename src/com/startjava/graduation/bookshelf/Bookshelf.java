package com.startjava.graduation.bookshelf;

import java.util.Arrays;
import java.util.Scanner;

public class Bookshelf {

    public static final int MAX_BOOKS = 10;
    private int shelfFullness;
    private final Book[] books = new Book[MAX_BOOKS];

    public void add() throws IndexOutOfBoundsException {
        if (shelfFullness >= MAX_BOOKS) {
            System.out.println("Ошибка: в шкафу закончились свободные полки");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите книгу в формате 'Имя автора, название книги, год издания'");

            String[] string = sc.nextLine().split(", ");
            Book book = new Book(string[0], string[1], Integer.parseInt(string[2]));
            books[shelfFullness++] = book;
        }
    }

    public int find() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название книги: ");
        String title = sc.nextLine();

        for (int i = 0; i < shelfFullness; i++) {
            if (title.equals(books[i].getTitle())) {
                return i;
            }
        }
        return -1;
    }

    public void delete(int bookPlace) {
        if (bookPlace >= 0) {
            System.arraycopy(books, bookPlace + 1, books, bookPlace, shelfFullness - bookPlace - 1);
            shelfFullness--;
        } else {
            System.out.println("Ошибка: книга не найдена");
        }
    }

    public void clear() {
        Arrays.fill(books, null);
        shelfFullness = 0;
    }

    public int getShelfFullness() {
        return shelfFullness;
    }

    public Book[] getBooks() {
        return Arrays.copyOf(books, shelfFullness);
    }

    public int getFreeShelves() {
        return MAX_BOOKS - shelfFullness;
    }

    public Book getBook(int place) {
        return books[place];
    }
}