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
        int shelfFullness = bs.getCountBooks();
        if (shelfFullness == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
        } else {
            System.out.printf("В шкафу %d книг и свободно %d полок%n%n", bs.getCountBooks(), bs.getFreeShelves());
            for (Book book : bs.getBooks()) {
                showBook(book.getTitle(), bs);
                System.out.println("|" + "-".repeat(bs.getShelfLength()) + "|");
            }
            if (shelfFullness < Bookshelf.CAPACITY) {
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
            case "add" -> bs.add(inputBookInfo(sc));
            case "find" -> showFindResult(bs.find(inputTitle(sc)), bs);
            case "delete" -> bs.delete(inputTitle(sc));
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

    private static String inputBookInfo(Scanner sc) {
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
            System.out.print(bs.getBooks()[place]);
        } else {
            System.out.print("книга не найдена");
        }
        System.out.println();
    }

    private static void showBook(String title, Bookshelf bs) {
        int place = bs.find(title);
        if (place >= 0) {
            Book book = bs.getBook(title);
            System.out.println("|" + book + " ".repeat(bs.getShelfLength() - book.getLength()) + "|");
        } else {
            System.out.print("Книга не найдена");
        }
    }
}