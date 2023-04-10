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
            System.out.println("Число равно " + num);
        }

        System.out.println("\n4. Поиск одинаковых цифр в числах");
        num1 = 318;
        num2 = 238;
        int hundredsNum1 = num1 / 100;
        int tensNum1 = num1 / 10 % 10;
        int onesNum1 = num1 % 10;
        int hundredsNum2 = num2 / 100;
        int tensNum2 = num2 / 10 % 10;
        int onesNum2 = num2 % 10;

        System.out.println("Первое число: " + num1 + "\nВторое число: " + num2);
        if (hundredsNum1 == hundredsNum2 || tensNum1 == tensNum2 || onesNum1 == onesNum2) {
            if (hundredsNum1 == hundredsNum2) {
                System.out.println("Одинаковая цифра в разряде сотен: " + hundredsNum1);
            }

            if (tensNum1 == tensNum2) {
                System.out.println("Одинаковая цифра в разряде десятков: " + tensNum1);
            }

            if (onesNum1 == onesNum2) {
                System.out.println("Одинаковая цифра в разряде единиц: " + onesNum1);
            }
        } else {
            System.out.println("Одинаковые цифры отсутствуют");
        }

        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';

        if (symbol >= 'a' && symbol <= 'z') {
            System.out.println("Это маленькая буква");
        } else if (symbol >= 'A' && symbol <= 'Z') {
            System.out.println("Это большая буква");
        } else if (symbol >= '0' && symbol <= '9') {
            System.out.println("Это число");
        } else {
            System.out.println("Это не буква и не число");
        }

        System.out.println("\n6. Подсчет суммы вклада и начисленных банком %");
        int deposit = 300000;
        double percent = 0.05; 

        System.out.println("Сумма вклада: " + deposit);
        if (deposit >= 100000 && deposit <= 300000) {
            percent = 0.07;
        } else if (deposit > 300000) {
            percent = 0.1;
        }

        double accruedPercent = deposit * percent;
        System.out.println("Начисленный %: " + accruedPercent);
        System.out.println("Итоговая сумма с %: " + (deposit + accruedPercent));

        System.out.println("\n7. Определение оценки по предметам");
        double historyPercent = 0.59;
        int historyGrade = 2;
        if (historyPercent > 0.91) {
            historyGrade = 5;
        } else if (historyPercent > 0.73) {
            historyGrade = 4;
        } else if (historyPercent > 0.60) {
            historyGrade = 3;
        }

        double programmingPercent = 0.91;
        int programmingGrade = 2;
        if (programmingPercent > 0.91) {
            programmingGrade = 5;
        } else if (programmingPercent > 0.73) {
            programmingGrade = 4;
        } else if (programmingPercent > 0.60) {
            programmingGrade = 3;
        }

        System.out.println("История: " + historyGrade);
        System.out.println("Программирование: " + programmingGrade);
        System.out.println("Средний бал оценок по предмету: " + 
                ((historyGrade + programmingGrade) / 2));
        System.out.println("Средний процент по предметам: " + 
                ((historyPercent + programmingPercent) / 2));

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
        int tensToWithdraw = moneyToWithdraw % 100 / 10;
        int onesToWithdraw = moneyToWithdraw % 10;
        int sumBanknotes10 = countBanknotes10 * 10;
        int sumBanknotes100 = countBanknotes100 * 100;

        boolean isNotEnoughFunds = sumBanknotes100 + sumBanknotes10 + countBanknotes1 < moneyToWithdraw;
        boolean isNotEnoughOnes = (sumBanknotes10 - tensToWithdraw >= 0 && countBanknotes1 < onesToWithdraw) || 
                (countBanknotes1 < tensToWithdraw * 10 - sumBanknotes10 + onesToWithdraw);
        if (isNotEnoughFunds || isNotEnoughOnes) {
            System.out.println("В банкомате недостаточно средств");
        } else {
            if (moneyToWithdraw >= 100 && moneyToWithdraw / 100 <= countBanknotes100) {
                issuedBanknotes100 = moneyToWithdraw / 100;
                moneyToWithdraw -= issuedBanknotes100 * 100;
            } else if (moneyToWithdraw >= 100 && moneyToWithdraw / 100 > countBanknotes100) {
                issuedBanknotes100 = countBanknotes100;
                moneyToWithdraw -= sumBanknotes100;
            }

            if (moneyToWithdraw >= 10 && moneyToWithdraw / 10 <= countBanknotes10) {
                issuedBanknotes10 = moneyToWithdraw / 10;
                moneyToWithdraw -= issuedBanknotes10 * 10;
            } else if (moneyToWithdraw >= 10 && moneyToWithdraw / 10 > countBanknotes10) {
                issuedBanknotes10 = countBanknotes10;
                moneyToWithdraw -= sumBanknotes10;
            }

            if (moneyToWithdraw >= 1 && moneyToWithdraw / 1 <= countBanknotes1) {
                issuedBanknotes1 = moneyToWithdraw / 1;
                moneyToWithdraw -= issuedBanknotes1 * 1;
            } else if (moneyToWithdraw >= 1 && moneyToWithdraw / 1 > countBanknotes1) {
                issuedBanknotes1 = countBanknotes1;
                moneyToWithdraw -= countBanknotes1;
            }

            System.out.println("Выдано: ");
            System.out.println("Банкнот номиналом 100: " + issuedBanknotes100);
            System.out.println("Банкнот номиналом 10: " + issuedBanknotes10);
            System.out.println("Банкнот номиналом 1: " + issuedBanknotes1);
            System.out.println("Сумма: " +
                    (issuedBanknotes100 * 100 + issuedBanknotes10 * 10 + issuedBanknotes1));
        } 
    }
}