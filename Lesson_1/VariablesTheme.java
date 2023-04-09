class VariablesTheme {

    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        byte systemBitDepth = 64;
        short cpuFrequency = 3500;
        int ramSize = 16392;
        long permanentMemorySize = 512000;
        float systemVersion = 10.1f;
        double priceInThousands = 72.560;
        char systemDriveName = 'C';
        boolean isWorking = true;

        System.out.println("Разрядность системы: " + systemBitDepth);
        System.out.println("Частота процессора: " + cpuFrequency);
        System.out.println("Объем оперативной памяти: " + ramSize);
        System.out.println("Объем долговременной памяти: " + permanentMemorySize);
        System.out.println("Версия системы: " + systemVersion);
        System.out.println("Цена в тысячах: " + priceInThousands);
        System.out.println("Имя системного диска: " + systemDriveName);
        System.out.println("Рабочий ?: " + isWorking);

        System.out.println("\n2. Расчет стоимости товара со скидкой");
        int penCost = 100;
        int bookCost = 200;
        int sumCost = penCost + bookCost;
        float discount = 0.11f;
        float sumDiscount = sumCost * discount;
        System.out.println("Общая стоимость товаров без скидки: " + sumCost);
        System.out.println("Сумма скидки: " + sumDiscount);
        System.out.println("Общая стоимость товаров со скидкой: " + (sumCost - sumDiscount));

        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a   ");
        System.out.println("   J   a a  v   v  a a  ");
        System.out.println("J  J  aaaaa  V V  aaaaa ");
        System.out.println(" JJ  a     a  V  a     a");

        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte maxByte = 127;
        short maxShort = 32767;
        int maxInteger = 2147483647;
        long maxLong = 9223372036854775807l;
        System.out.println("Первоначальное значение maxByte: " + maxByte);
        System.out.println("Значение maxByte после инкремента на единицу: " + ++maxByte);
        System.out.println("Значение maxByte после декремента на единицу: " + --maxByte);
        System.out.println("Первоначальное значение maxShort: " + maxShort);
        System.out.println("Значение maxShort после инкремента на единицу: " + ++maxShort);
        System.out.println("Значение maxShort после декремента на единицу: " + --maxShort);
        System.out.println("Первоначальное значение maxInteger: " + maxInteger);
        System.out.println("Значение maxInteger после инкремента на единицу: " + ++maxInteger);
        System.out.println("Значение maxInteger после декремента на единицу: " + --maxInteger);
        System.out.println("Первоначальное значение maxLong: " + maxLong);
        System.out.println("Значение maxLong после инкремента на единицу: " + ++maxLong);
        System.out.println("Значение maxLong после декремента на единицу: " + --maxLong);

        System.out.println("\n5. Перестановка значений переменных");
        int num1 = 2;
        int num2 = 5;
        int tmp = num1;

        System.out.println("I Перестановка с помощью третьей переменной: ");
        System.out.println("Исходные значения переменных: num1 = " + num1 + ", num2 = " + num2);
        num1 = num2;
        num2 = tmp;
        System.out.println("Новые значения переменных: num1 = " + num1 + ", num2 = " + num2);

        System.out.println("II Перестановка с помощью арифметических операций: ");
        System.out.println("Исходные значения переменных: num1 = " + num1 + ", num2 = " + num2);
        num1 += num2;
        num2 = num1 - num2;
        num1 -= num2;
        System.out.println("Новые значения переменных: num1 = " + num1 + ", num2 = " + num2);

        System.out.println("III Перестановка с помощью побитовой операции: ");
        System.out.println("Исходные значения переменных: num1 = " + num1 + ", num2 = " + num2);
        num1 ^= num2;
        num2 = num1 ^ num2;
        num1 ^= num2;
        System.out.println("Новые значения переменных: num1 = " + num1 + ", num2 = " + num2);

        System.out.println("\n6. Вывод символов и их кодов");
        char lattice = '#';
        char ampersand = '&';
        char at = '@';
        char circumflex = '^';
        char underscore = '_';

        System.out.println("Код символа: " + (byte) lattice + 
                "; Соответствующий символ: " + lattice);
        System.out.println("Код символа: " + (byte) ampersand + 
                "; Соответствующий символ: " + ampersand);
        System.out.println("Код символа: " + (byte) at + "; Соответствующий символ: " + at);
        System.out.println("Код символа: " + (byte) circumflex + 
                "; Соответствующий символ: " + circumflex);
        System.out.println("Код символа: " + (byte) underscore + 
                "; Соответствующий символ: " + underscore);

        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        char slash = '/';
        char backslash = '\\';
        char underline = '_';
        char leftParentheses = '(';
        char rightParentheses = ')';

        System.out.println("    " + slash + backslash);
        System.out.println("   " + slash + "  " + backslash);
        System.out.println("  " + slash + underline + leftParentheses + " " + rightParentheses + backslash);
        System.out.println(" " + slash + "      " + backslash);
        System.out.println("" + slash + underline + underline + underline + underline + slash + backslash + 
                underline  + underline + backslash);

        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        int num = 123;
        int hundreds = num / 100;
        int tens = (num / 10) % 10;
        int ones = num % 10;
        int sumDigits = hundreds + tens + ones;
        int productDigits = hundreds * tens * ones;

        System.out.println("Число " + num + " содержит: ");
        System.out.println("    " + hundreds + " сотен");
        System.out.println("    " + tens + " десятков");
        System.out.println("    " + ones + " единиц");
        System.out.println("Сумма его цифр = " + sumDigits);
        System.out.println("Произведение = " + productDigits);

        System.out.println("\n9. Вывод времени");
        int initialSecond = 86399;
        int hours = initialSecond / 3600;
        int minutes = initialSecond % 3600 / 60;
        int seconds =  initialSecond % 60;

        System.out.println(hours + ":" + minutes + ":" + seconds);
    }
}