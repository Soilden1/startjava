package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            Calculator calculator = new Calculator();
            System.out.print("Введите математическое выражение: ");
            String mathematicalExpression = sc.nextLine();
            calculator.setMathematicalExpression(mathematicalExpression);
            double result = calculator.calculate();

            if (result % 1 > 0) {
                System.out.printf("%.3f", result);
            } else {
                System.out.print((int) result);
            }

            System.out.println("\nХотите продолжить вычисления? [yes/no]");
            String continuation = sc.nextLine();
            if (!continuation.equals("yes")) {
                break;
            }
        }
    }
}