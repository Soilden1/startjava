package com.startjava.lesson_2_3.calculator;

public class Calculator {

    private int num1;
    private int num2;
    private char sign;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    public void calculate() {
        int resault = 1;

        switch (sign) {
            case '+':
                resault = num1 + num2;
                break;
            case '-':
                resault = num1 - num2;
                break;
            case '*':
                resault = num1 * num2;
                break;
            case '/':
                resault = num1 / num2;
                break;
            case '%':
                resault = num1 % num2;
                break;
            case '^':
                for (int i = 1; i <= num2; i++) {
                    resault *= num1;
                }
                break;
            default:
                System.out.println("Введенная операция не поддерживается");
                return;
        }

        System.out.println(num1 + " " + sign + " " + num2 + " = " + resault);
    }
}