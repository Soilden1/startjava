package com.startjava.lesson_1.base;

class CyclesTheme {

    public static void main(String[] args) {
        System.out.println("\n1. Подсчет суммы четных и нечетных чисел");
        int counter = -10;
        int sumEven = 0;
        int sumOdd = 0;
        do {
            if (counter % 2 == 0) {
                sumEven += counter;
            } else {
                sumOdd += counter;
            }

            counter++;
        } while (counter <= 21);

        System.out.println("В промежутке [-10, 21] сумма четных чисел = " + sumEven +
                ", а нечетных = " + sumOdd);

        System.out.println("\n2. Вывод чисел в интервале (min и max) в порядке убывания");
        int num1 = 10;
        int num2 = 5;
        int num3 = -1;

        int max = num1;
        if (num1 < num2) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }

        int min = num1;
        if (num1 > num2) {
            min = num2;
        }
        if (num3 < max) {
            min = num3;
        }

        for (int i = max - 1; i > min; i--) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n3. Вывод реверсивного числа и суммы его цифр");
        int num = 1234;
        int sum = 0;

        System.out.print("Исходное число в обратном порядке: ");
        while (num > 0) {
            int lastDigit = num % 10;
            num /= 10;
            sum += lastDigit;
            System.out.print(lastDigit);
        }

        System.out.println("\nСумма цифр числа: " + sum);

        System.out.println("\n4. Вывод чисел на консоль в несколько строк");
        counter = 0;
        for (int i = 1; i < 24; i += 2) {
            counter++;
            if (counter == 5) {
                System.out.printf("%4d%n", i);
                counter = 0;
            } else {
                System.out.printf("%4d", i);
            }
        }

        if (counter > 0) {
            while (counter < 5) {
                System.out.printf("%4d", 0);
                counter++;
            }
        }

        System.out.println("\n\n5. Проверка количества двоек на четность/нечетность");
        num =  3242592;
        int countTwos = 0;
        int copyNum = num;
        while (copyNum > 0) {
            if (copyNum % 10 == 2) {
                countTwos++;
            }
            copyNum /= 10;
        }

        String property = "четное";
        if (countTwos % 2 > 0) {
            property = "нечетное";
        }

        System.out.printf("Число %d содержит %s количество двоек%n", num, property);

        System.out.println("\n6. Отображение фигур в консоли");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('*');
            }
            System.out.println();
        }

        System.out.println();
        counter = 5;
        while (counter > 0) {
            int symbolCounter = counter;
            while (symbolCounter > 0) {
                System.out.print('#');
                symbolCounter--;
            }
            System.out.println();
            counter--;
        }

        System.out.println();
        boolean isBack = false;
        counter = 1;
        do {
            int symbolCounter = 1;
            do {
                System.out.print('$');
                symbolCounter++;
            } while (symbolCounter <= counter);
            if (counter < 3 && !isBack) {
                counter++;
            } else if (counter == 3 || isBack) {
                isBack = true;
                counter--;
            }
            System.out.println();
        } while (counter > 0);

        System.out.println("\n7. Отображение ASCII-символов");
        System.out.printf("%6s%6s%n", "Dec", "Char");
        for (int i = 0; i <= 122; i++) {
            boolean oddDecSymbolToNumbers = i < 48 && i % 2 != 0;
            boolean evenDecSmallLetters = i >= 97 && i <= 122 && i % 2 == 0;
            if (oddDecSymbolToNumbers || evenDecSmallLetters) {
                System.out.printf("%6d%6c%n", i, (char) i);
            }
        }

        System.out.println("\n8. Проверка, является ли число палиндромом");
        num = 1234321;
        copyNum = num;
        int reversNum = 0;
        while (copyNum > 0) {
            reversNum = reversNum * 10 + copyNum % 10;
            copyNum /= 10;
        }

        String isPalindrome;
        if (num == reversNum) {
            isPalindrome = "является";
        } else {
            isPalindrome = "не является";
        }
        System.out.printf("Число %d %s палиндромом%n", num, isPalindrome);

        System.out.println("\n9. Определение, является ли число счастливым");
        num = 132321;
        int firstThreeDigits = num / 1000;
        int lastThreeDigits = num % 1000;
        int copyFirstThreeDigits = firstThreeDigits;
        int copyLastThreeDigits = lastThreeDigits;
        int sumFirstThreeDigits = 0;
        int sumLastThreeDigits = 0;

        for (int i = 0; i < 3; i++) {
            sumLastThreeDigits += copyLastThreeDigits % 10;
            copyLastThreeDigits /= 10;
            sumFirstThreeDigits += copyFirstThreeDigits % 10;
            copyFirstThreeDigits /= 10;
        }

        System.out.printf("Сумма цифр %d = %d%n", firstThreeDigits, sumFirstThreeDigits);
        System.out.printf("Сумма цифр %d = %d%n", lastThreeDigits, sumLastThreeDigits);

        String isLucky = "счастливое";
        if (sumFirstThreeDigits != sumLastThreeDigits) {
            isLucky = "не счастливое";
        }

        System.out.printf("Число %d %s%n", num, isLucky);

        System.out.println("\n10.Вывод таблицы умножения Пифагора");
        System.out.printf("%4s%-13s%-13s%n", "    ", "ТАБЛИЦА", "ПИФАГОРА");
        System.out.println("   |  2  3  4  5  6  7  8  9");
        System.out.println("---|------------------------");

        for (int i = 2; i <= 9; i++) {
            System.out.printf("%4s", i + " |");

            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }

            System.out.println();
        }
    }
}