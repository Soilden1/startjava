package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuation = "yes";

        while (continuation.equals("yes")) {
            System.out.print("Введите математическое выражение: ");
            String mathExpression = sc.nextLine();
            try {
                if (isValid(mathExpression)) {
                    print(Calculator.calculate(mathExpression));
                }
            } catch (NumberFormatException formatException) {
                System.out.println("Ошибка: введены невалидные данные, вводите выражение в формате 'a + b'");
            }

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]");
                continuation = sc.nextLine();
            } while (!continuation.equals("yes") && !continuation.equals("no"));
        }
    }

    private static void print(double result) {
        System.out.printf(result % 1 > 0 ? ("%.3f%n") : ("%.0f%n"), result);
    }

    private static boolean isValid(String mathExpression) {
        String[] elements = mathExpression.split(" ");
        if (elements.length != 3) {
            System.out.println("Ошибка: введены невалидные данные, вводите выражение в формате 'a + b'");
            return false;
        }
        if (mathExpression.contains(".") || elements[0].contains("-") || elements[2].contains("-")) {
            System.out.println("Ошибка: вводимые числа должны быть целыми и положительными");
            return false;
        }
        return true;
    }
}