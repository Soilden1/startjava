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
            for (Book book : bs.getBooks()) {
                System.out.print("|");
                showBook(book.getTitle(), bs);
                System.out.println("|");
                System.out.println("|" + "-".repeat(shelfLength) + "|");
                if (book.getLength() == shelfFullness - 1 && shelfFullness < Bookshelf.CAPACITY) {
                    System.out.println("|" + " ".repeat(shelfLength) + "|");
                }
            }
        }
    }

    private static void showBook(String title, Bookshelf bs) {
        int place = bs.find(title);
        if (place >= 0) {
            Book book = bs.getBook(title);
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
                String book = inputBook(sc);
                try {
                    bs.add(book);
                    int length = book.length();
                    if (length > shelfLength) {
                        shelfLength = length;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Ошибка: невалидный формат");
                }
            }
            case "find" -> showFindResult(bs.find(inputTitle(sc)), bs);
            case "delete" -> {
                String title = inputTitle(sc);
                int bookPlace = bs.find(title);
                if (bookPlace >= 0) {
                    int length = bs.getBook(title).getLength();
                    bs.delete(title);
                    if (length == shelfLength) {
                        calculateLength(bs);
                    }
                } else {
                    System.out.println("Ошибка: книга не найдена");
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

    private static String inputBook(Scanner sc) {
        System.out.println("Введите книгу в формате 'Имя автора, название книги, год издания'");
        return sc.nextLine();
    }

    private static String inputTitle(Scanner sc) {
        System.out.print("Введите название книги: ");
        return sc.nextLine();
    }

    private static void showFindResult(int place, Bookshelf bs) {
        System.out.print("Результат поиска: ");
        if (place >= 0) {
            showBook(bs.getBooks()[place].getTitle(), bs);
        } else {
            System.out.print("книга не найдена");
        }
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