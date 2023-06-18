package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {

    private static int shelfLength;

    public static void main(String[] args) {
        Bookshelf bs = new Bookshelf();
        do {
            showBookshelf(bs);
            showMenu();
        } while (isLaunch(bs));
    }

    private static void showBookshelf(Bookshelf bs) {
        int shelfFullness = bs.getCountBooks();
        if (shelfFullness == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
        } else {
            System.out.printf("В шкафу %d книг и свободно %d полок%n%n", bs.getCountBooks(), bs.getFreeShelves());
            for (int i = 0; i < shelfFullness; i++) {
                System.out.print("|");
                showBook(i, bs);
                System.out.println("|");
                System.out.println("|" + "-".repeat(shelfLength) + "|");
                if (i == shelfFullness - 1 && shelfFullness < Bookshelf.CAPACITY) {
                    System.out.println("|" + " ".repeat(shelfLength) + "|");
                }
            }
        }
    }

    private static void showBook(int place, Bookshelf bs) {
        if (place >= 0) {
            Book book = bs.getBook(place);
            System.out.print(book + " ".repeat(shelfLength - book.getLength()));
        } else {
            System.out.print("Книга не найдена");
        }
    }

    private static void showMenu() {
        System.out.print("""
                MENU
                1. add
                2. find
                3. delete
                4. clear
                5. quit
                """);
    }

    private static boolean isLaunch(Bookshelf bs) {
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine()) {
            case "add" -> {
                try {
                    bs.add();
                    int length = bs.getBook(bs.getCountBooks() - 1).getLength();
                    if (length > shelfLength) {
                        shelfLength = length;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Ошибка: невалидный формат");
                }
            }
            case "find" -> showFindResult(bs.find(), bs);
            case "delete" -> {
                int bookPlace = bs.find();
                if (bookPlace >= 0) {
                    int length = bs.getBook(bookPlace).getLength();
                    bs.delete(bookPlace);
                    if (length == shelfLength) {
                        calculateLength(bs);
                    }
                } else {
                    System.out.println("Книга не найдена");
                }
            }
            case "clear" -> {
                bs.clear();
                shelfLength = 0;
            }
            case "quit" -> {return false;}
            default -> {
                System.out.println("Ошибка: такой функции не существует");
                isLaunch(bs);
                return true;
            }
        }
        System.out.println("Для продолжения работы нажмите Enter");
        sc.nextLine();
        return true;
    }

    private static void showFindResult(int place, Bookshelf bs) {
        System.out.print("Результат поиска: ");
        showBook(place, bs);
        System.out.println();
    }

    private static void calculateLength(Bookshelf bs) {
        shelfLength = 0;
        for (Book book : bs.getBooks()) {
            int length = book.getLength();
            if (length > shelfLength) {
                shelfLength = length;
            }
        }
    }
}