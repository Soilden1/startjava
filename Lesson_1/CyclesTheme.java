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
        if (num1 > num2) {
            max = num1;
        } else {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }

        int min = num1;
        if (num1 < num2) {
            min = num1;
        } else {
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
        int copyNum1 = num;
        boolean isPalindrome = true;

        while (copyNum1 >= 10) {
            int firstDigit = copyNum1;
            int copyNum2 = copyNum1;
            int counterZero = 0;

            if (copyNum1 >= 10) {
                while (copyNum2 > 0) {
                    copyNum2 /= 10;
                    if (copyNum2 > 0) {
                        firstDigit = copyNum2;
                        counterZero++;
                    }
                }
            }

            if (firstDigit != copyNum1 % 10) {
                isPalindrome = false;
            }
            copyNum1 /= 10;

            int placeFirstDigit = 1;
            for (int i = 0; i < counterZero; i++) {
                placeFirstDigit *= 10;
            }
            copyNum1 -= placeFirstDigit * firstDigit;
        }

        if (isPalindrome) {
            System.out.printf("Число %d является палиндромом%n", num);
        }

        System.out.println("\n9. Определение, является ли число счастливым");
        num = 132321;
        int firstThreeDigit = num;
        int lastThreeDigit = 0;

        int counterPlace = 0;
        int placeLastDigit = 1;
        for (int i = 0; i < 3; i++) {
            if (counterPlace > 0) {
                placeLastDigit *= 10;
            }

            lastThreeDigit += firstThreeDigit % 10 * placeLastDigit;
            firstThreeDigit /= 10;
            counterPlace++;
        }

        int sumFirstThreeDigit = 0;
        int sumLastThreeDigit = 0;
        int firstThreeDigitCopy = firstThreeDigit;
        int lastThreeDigitCopy = lastThreeDigit;
        for (int i = 0; i < 3; i++) {
            sumFirstThreeDigit += firstThreeDigitCopy % 10;
            firstThreeDigitCopy /= 10;
            sumLastThreeDigit += lastThreeDigitCopy % 10;
            lastThreeDigitCopy /= 10;
        }

        System.out.printf("Сумма цифр %d = %d%n", firstThreeDigit, sumFirstThreeDigit);
        System.out.printf("Сумма цифр %d = %d%n", lastThreeDigit, sumLastThreeDigit);
        
        String isLucky = "счастливое";
        if (sumFirstThreeDigit != sumLastThreeDigit) {
            isLucky = "не счастливое";
        }

        System.out.printf("Число %d %s%n", num, isLucky);

        System.out.println("\n10.Вывод таблицы умножения Пифагора");
        System.out.printf("%4s%-13s%-13s%n", "    ", "ТАБЛИЦА", "ПИФАГОРА");

        for (int i = 1; i <= 9; i++) {
            if (i > 1) {
                System.out.printf("%4s", i + " |");
            } else {
                System.out.printf("%4s", "  |");
            }

            for (int j = 2; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }

            if (i == 1) {
                System.out.println();
                for (int k = 1; k <= 9; k++) {
                    if (k == 1) {
                        System.out.print("---|");
                    } else {
                        System.out.print("---");
                    }
                }
            }
            System.out.println();
        }
    }
}