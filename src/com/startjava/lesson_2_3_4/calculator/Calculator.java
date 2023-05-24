package com.startjava.lesson_2_3_4.calculator;

public class Calculator {

    private String mathematicalExpression;

    public void setMathematicalExpression(String mathematicalExpression) {
        this.mathematicalExpression = mathematicalExpression;
    }

    public double calculate() {
        double result;
        String[] mathematicalElements = mathematicalExpression.split(" ");
        char sign = mathematicalElements[1].charAt(0);
        int num1 = Integer.parseInt(mathematicalElements[0]);
        int num2 = Integer.parseInt(mathematicalElements[2]);

        switch (sign) {
            case '+':
                result = Math.addExact(num1, num2);
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = Math.multiplyExact(num1, num2);
                break;
            case '/':
                result = (double) num1 / num2;
                break;
            case '%':
                result = num1 % num2;
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            default:
                System.out.println("Введенная операция не поддерживается");
                return 0.0;
        }
        return result;
    }
}