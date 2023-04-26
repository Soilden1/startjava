import java.util.Scanner;

public class CalculatorTest {
    
    public static void main(String[] args) {
        String contin = "yes";
        Scanner sc = new Scanner(System.in);

        while (contin.equals("yes")) {
            Calculator calculator = new Calculator();
            System.out.print("Введите первое число: ");
            int num1 = sc.nextInt();
            calculator.setNum1(num1);
            System.out.print("Введите знак математической операции: ");
            char sign = sc.next().charAt(0);
            calculator.setSign(sign);
            System.out.print("Введите второе число: ");
            int num2 = sc.nextInt();
            calculator.setNum2(num2);
            calculator.calculate();

            do {
                System.out.println("Хотите продолжить вычисления? [yes/no]");
                contin = sc.next();
            } while (!contin.equals("yes") && !contin.equals("no"));
        }
    }
}