package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    public double calculate(String mathematicalExpression) {
        String[] elements = mathematicalExpression.split(" ");
        char sign = elements[1].charAt(0);
        int num1 = Integer.parseInt(elements[0]);
        int num2 = Integer.parseInt(elements[2]);

        switch (sign) {
            case '+':
                return Math.addExact(num1, num2);
            case '-':
                return num1 - num2;
            case '*':
                return Math.multiplyExact(num1, num2);
            case '/':
                return  (double) num1 / num2;
            case '%':
                return num1 % num2;
            case '^':
                return Math.pow(num1, num2);
            default:
                System.out.println("Введенная операция не поддерживается");
                return 0.0;
        }
    }
}