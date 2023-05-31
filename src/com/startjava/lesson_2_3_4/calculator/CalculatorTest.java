package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuation = "yes";
        while (!continuation.equals("no")) {
            if (continuation.equals("yes")) {
                System.out.print("Введите математическое выражение: ");
                String mathExpression = sc.nextLine();
                print(Calculator.calculate(mathExpression));
            }
            System.out.println("Хотите продолжить вычисления? [yes/no]");
            continuation = sc.nextLine();
        }
    }

    private static void print(double result) {
        System.out.printf(result % 1 > 0 ? ("%.3f%n") : ("%.0f%n"), result);
    }
}