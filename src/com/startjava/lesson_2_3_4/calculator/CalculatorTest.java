package com.startjava.lesson_2_3_4.calculator;

import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuation = "yes";

        while (continuation.equals("yes")) {
            Calculator calculator = new Calculator();
            System.out.print("Введите математическое выражение: ");
            print(calculator.calculate(sc.nextLine()));

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]");
                continuation = sc.nextLine();
            } while (!continuation.equals("yes") && !continuation.equals("no"));
        }
    }

    private static void print(double result) {
        if (result % 1 > 0) {
            System.out.printf("%n%.3f", result);
        } else {
            System.out.println((int) result);
        }
    }
}