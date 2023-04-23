import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        String isContinue = "yes";

        while (isContinue.equals("yes")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введите первое число: ");
            int num1 = sc.nextInt();
            System.out.print("Введите знак математической операции: ");
            char sign = sc.next().charAt(0);
            System.out.print("Введите второе число: ");
            int num2 = sc.nextInt();

            Calculator calculator = new Calculator();
            calculator.setNum1(num1);
            calculator.setNum2(num2);
            calculator.setSign(sign);
            calculator.calculate();

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]");
                isContinue = sc.next();
            } while (!isContinue.equals("yes") && !isContinue.equals("no"));
        }
    }
}