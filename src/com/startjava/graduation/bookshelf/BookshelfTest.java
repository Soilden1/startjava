package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {

    public static void main(String[] args) {
        Bookshelf bs = new Bookshelf();
        do {
            showBookshelf(bs);
            showMenu();
        } while (isLaunch(bs));
    }

    private static void showBookshelf(Bookshelf bs) {
        int countBooks = bs.getCountBooks();
        if (countBooks == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
        } else {
            System.out.printf("В шкафу %d книг и свободно %d полок%n%n", countBooks, bs.getFreeShelves());
            for (Book book : bs.getBooks()) {
                System.out.println("|" + book + " ".repeat(bs.getShelfLength() - book.getLength()) + "|");
                System.out.println("|" + "-".repeat(bs.getShelfLength()) + "|");
            }
            if (countBooks < Bookshelf.CAPACITY) {
                System.out.println("|" + " ".repeat(bs.getShelfLength()) + "|");
            }
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
            case "add" -> add(sc, bs);
            case "find" -> find(sc, bs);
            case "delete" -> delete(sc, bs);
            case "clear" -> bs.clear();
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

    private static void add(Scanner sc, Bookshelf bs) {
        System.out.println("Введите книгу в формате 'Имя автора, название книги, год издания'");
        bs.add(sc.nextLine());
    }

    private static void delete(Scanner sc, Bookshelf bs) {
        System.out.print("Введите название книги: ");
        bs.delete(sc.nextLine());
    }

    private static void find(Scanner sc, Bookshelf bs) {
        System.out.print("Введите название книги: ");
        Book book = bs.getBook(sc.nextLine());

        System.out.print("Результат поиска: ");
        System.out.print(book == null ? "Книга не найдена" : book);
        System.out.println();
    }
}