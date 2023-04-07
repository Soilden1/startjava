class IfElseStatementTheme {
    
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        int age = 20;
        if (age > 20) {
            System.out.println("Возраст больше 20");
        } else {
            System.out.println("Возраст меньше или равен 20");
        }

        String gender = "male";
        if (gender != "male") {
            System.out.println("Женский пол");
        } else {
            System.out.println("Мужской пол");
        }

        int height = 182;
        if (height < 180) {
            System.out.println("Рост меньше 180");
        } else {
            System.out.println("Рост больше или равен 180");
        }

        char firstLetterName = "Ivan Ivanov".charAt(0);
        if (firstLetterName == 'М') {
            System.out.println("Имя начинается с буквы М");
        } else if (firstLetterName == 'I') {
            System.out.println("Имя начинается с буквы I");
        } else {
            System.out.println("Имя не начинается с букв M и I");
        }


        System.out.println("\n2. Поиск max и min числа");
        int num1 = 10;
        int num2 = 20;

        if (num1 > num2) {
            System.out.println("Максимальное число: " + num1 + "; Минимальное число: " + num2);
        } else if (num1 < num2) {
            System.out.println("Максимальное число: " + num2 + "; Минимальное число: " + num1);
        } else {
            System.out.println("Число: " + num1 + " равно числу " + num2);
        }


        System.out.println("\n3. Проверка числа");
        int num = 142;

        System.out.println("Исходное число: " + num);
        if (num != 0) {
            if (num % 2 == 0) {
                System.out.println("Число четное");
            } else {
                System.out.println("Число нечетное");
            }

            if (num > 0) {
                System.out.println("Число положительное");
            } else {
                System.out.println("Число отрицательное");
            }

        } else {
            System.out.println("Число равно нулю");
        }


        System.out.println("\n4. Поиск одинаковых цифр в числах");
        num1 = 318;
        num2 = 238;
        int hitCounter = 0;

        System.out.println("Первое число: " + num1 + "\nВторое число: " + num2);
        if (num1 / 100 == num2 / 100) {
            System.out.println("Одинаковая цифра в разряде сотен: " + num1 /100);
            hitCounter++;
        }

        if (num1 / 10 % 10 == num2 / 10 % 10) {
            System.out.println("Одинаковая цифра в разряде десятков: " + num1 / 10 % 10);
            hitCounter++;
        }

        if (num1 % 10 == num2 % 10) {
            System.out.println("Одинаковая цифра в разряде единиц: " + num1 % 10);
            hitCounter++;
        }

        if (hitCounter == 0) {
            System.out.println("Одинаковые цифры отсутствуют");
        }


        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';

        if (symbol >= 97 && symbol <= 122) {
            System.out.println("Это маленькая буква");
        } else if (symbol >= 65 && symbol <= 90) {
            System.out.println("Это большая буква");
        } else if (symbol >= 48 && symbol <= 57) {
            System.out.println("Это число");
        } else {
            System.out.println("Это не буква и не число");
        }


        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        int deposit = 300000;

        System.out.println("Сумма вклада: " + deposit);
        if (deposit < 100000) {
            System.out.println("Начисленный %: " + deposit * 0.05);
            System.out.println("Итоговая сумма с %: " + (deposit + deposit * 0.05));
        } else if (deposit >= 100000 && deposit <= 300000) {
            System.out.println("Начисленный %: " + deposit * 0.07);
            System.out.println("Итоговая сумма с %: " + (deposit + deposit * 0.07));
        } else {
            System.out.println("Начисленный %: " + deposit * 0.1);
            System.out.println("Итоговая сумма с %: " + (deposit + deposit * 0.1));
        }


        System.out.println("\n7. Определение оценки по предметам");
        double historyPercent = 0.59;
        double programmingPercent = 0.91;
        int historyGrade = 0;
        int programmingGrade = 0;

        if (historyPercent <= 0.60) {
            historyGrade = 2;
        } else if (historyPercent > 0.91) {
            historyGrade = 5;
        } else if (historyPercent > 0.73) {
            historyGrade = 4;
        } else {
            historyGrade = 3;
        }

        if (programmingPercent <= 0.60) {
            programmingGrade = 2;
        } else if (programmingPercent > 0.91) {
            programmingGrade = 5;
        } else if (programmingPercent > 0.73) {
            programmingGrade = 4;
        } else {
            programmingGrade = 3;
        }

        System.out.println("История: " + historyGrade);
        System.out.println("Программирование: " + programmingGrade);
        System.out.println("Средний бал оценок по предмету: " + ((historyGrade 
                + programmingGrade) / 2));
        System.out.println("Средний процент по предметам: " + ((historyPercent 
                + programmingPercent) / 2));


        System.out.println("\n8. Расчет прибыли за год");
        int rentPrice = 5000;
        int salesProfit = 13000;
        int costGoods = 9000;
        int profitForYear = 12 * (salesProfit - rentPrice - costGoods);

        if (profitForYear > 0) {
            System.out.println("Прибыль за год: +" + profitForYear);
        } else {
            System.out.println("Прибыль за год: " + profitForYear);
        }


        System.out.println("\n9. Подсчет количества банкнот");
        int moneyToWithdraw = 567;
        int countBanknotes100 = 10;
        int countBanknotes10 = 5;
        int countBanknotes1 = 50;
        int issuedBanknotes100 = 0;
        int issuedBanknotes10 = 0;
        int issuedBanknotes1 = 0;

        if (countBanknotes100 * 100 + countBanknotes10 * 10 + countBanknotes1 >= moneyToWithdraw) {
            if (moneyToWithdraw >= 100 && moneyToWithdraw / 100 <= countBanknotes100) {
                issuedBanknotes100 = moneyToWithdraw / 100;
                moneyToWithdraw -= issuedBanknotes100 * 100;
            } else if (moneyToWithdraw >= 100 && moneyToWithdraw / 100 > countBanknotes100) {
                issuedBanknotes100 = countBanknotes100;
                moneyToWithdraw -= countBanknotes100 * 100;
            }

            if (moneyToWithdraw >= 10 && moneyToWithdraw / 10 <= countBanknotes10) {
                issuedBanknotes10 = moneyToWithdraw / 10;
                moneyToWithdraw -= issuedBanknotes10 * 10;
            } else if (moneyToWithdraw >= 10 && moneyToWithdraw / 10 > countBanknotes10) {
                issuedBanknotes10 = countBanknotes10;
                moneyToWithdraw -= countBanknotes10 * 10;
            }

            if (moneyToWithdraw >= 1 && moneyToWithdraw / 1 <= countBanknotes1) {
                issuedBanknotes1 = moneyToWithdraw / 1;
                moneyToWithdraw -= issuedBanknotes1 * 1;
            } else if (moneyToWithdraw >= 1 && moneyToWithdraw / 1 > countBanknotes1) {
                issuedBanknotes1 = countBanknotes1;
                moneyToWithdraw -= countBanknotes1 * 1;
            }

            if (moneyToWithdraw != 0) {
                System.out.println("В банкомате недостаточно банкнот для выдачи этой суммы, " + 
                        "попробуйте ввести округленную сумму");
            } else {
                System.out.println("Выдано: ");
                System.out.println("Банкнот номиналом 100: " + issuedBanknotes100);
                System.out.println("Банкнот номиналом 10: " + issuedBanknotes10);
                System.out.println("Банкнот номиналом 1: " + issuedBanknotes1);
                System.out.println("Сумма: " + (issuedBanknotes100 * 100 +
                        issuedBanknotes10 * 10 + issuedBanknotes1));
            } 
        } else {
            System.out.println("В банкомате недостаточно средств");
        } 
    }
}