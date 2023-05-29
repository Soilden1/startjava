package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Введите математическое выражение: ");
            String mathExpression = sc.nextLine();
            try {
                print(Calculator.calculate(mathExpression));
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Ошибка: введены невалидные данные, вводите выражение в формате 'a + b'");
            }

            System.out.println("Хотите продолжить вычисления? [yes/no]");
        } while (sc.nextLine().equals("yes"));
    }

    private static void print(double result) {
        System.out.printf(result % 1 > 0 ? ("%.3f%n") : ("%.0f%n"), result);
    }
}