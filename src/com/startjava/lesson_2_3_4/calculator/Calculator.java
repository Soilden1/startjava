package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public static double calculate(String mathExpression) {
        String[] elements = mathExpression.split(" ");
        char sign = elements[1].charAt(0);
        int num1 = Integer.parseInt(elements[0]);
        int num2 = Integer.parseInt(elements[2]);

        if (isValid(elements)) {
            return switch (sign) {
                case '+' -> Math.addExact(num1, num2);
                case '-' -> num1 - num2;
                case '*' -> Math.multiplyExact(num1, num2);
                case '/' -> (double) num1 / num2;
                case '%' -> num1 % num2;
                case '^' -> Math.pow(num1, num2);
                default -> {
                    System.out.println("Введенная операция не поддерживается");
                    yield 0.0;
                }
            };
        }
        return 0.0;
    }

    private static boolean isValid(String[] elements) {
        if (elements.length != 3) {
            System.out.println("Ошибка: введены невалидные данные, вводите выражение в формате 'a + b'");
            return false;
        }
        if (elements[0].contains(".") || elements[2].contains(".") ||
                elements[0].contains("-") || elements[2].contains("-")) {
            System.out.println("Ошибка: вводимые числа должны быть целыми и положительными");
            return false;
        }
        return true;
    }
}