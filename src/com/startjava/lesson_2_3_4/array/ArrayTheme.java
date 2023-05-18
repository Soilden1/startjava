package com.startjava.lesson_2_3_4.array;

import java.util.Random;
import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        System.out.println("1. Реверс значений массива");
        int[] intArray = {3, 7, 1, 2, 6, 4, 5};
        printIntArray(intArray);
        int length = intArray.length;
        for (int i = 0; i < length / 2; i++) {
            int tmp = intArray[i];
            intArray[i] = intArray[length - 1 - i];
            intArray[length - 1 - i] = tmp;
        }
        printIntArray(intArray);

        System.out.println("\n2. Вывод произведения элементов массива");
        intArray = new int[10];
        int prod = 1;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i;
            if (i > 0 && i < 9) {
                prod *= i;
                System.out.print(i < 8 ? i + " * " : i + " = " + prod + "\n");
            }
        }
        System.out.println(intArray[0] + "(index: 0) " + intArray[9] + "(index: 9)");

        System.out.println("\n3. Удаление элементов массива");
        Random random = new Random();
        double[] doubleArray = new double[15];
        length = doubleArray.length;
        for (int i = 0; i < length; i++) {
            doubleArray[i] = random.nextDouble(1);
        }
        printDoubleArray(doubleArray);

        int averageIndex = 0;
        for (int i = 0; i < length; i++) {
            int smallerNumberCounter = 0;
            int biggerNumberCounter = 0;
            for (double number : doubleArray) {
                if (number > doubleArray[i]) {
                    biggerNumberCounter++;
                } else {
                    smallerNumberCounter++;
                }
            }

            if (biggerNumberCounter + 1 == smallerNumberCounter) {
                averageIndex = i;
                break;
            }
        }

        double average = doubleArray[averageIndex];
        int zeroedCellsCounter = 0;
        for (int i = 0; i < length; i++) {
            if (doubleArray[i] > average) {
                doubleArray[i] = 0;
                zeroedCellsCounter++;
            }
        }
        printDoubleArray(doubleArray);
        System.out.println("Количество обнуленных ячеек: " + zeroedCellsCounter);

        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке");
        char[] deployedAlphabet = new char[26];
        int index = 0;
        for (char i = 'Z'; i >= 'A'; i--, index++) {
            deployedAlphabet[index] = i;
        }

        for (int i = 0; i < deployedAlphabet.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(deployedAlphabet[j]);
            }
            System.out.println();
        }

        System.out.println("\n5. Генерация уникальных чисел");
        intArray = new int[30];
        length = intArray.length;
        for (int i = 0; i < length; i++) {
            while (intArray[i] == 0) {
                int num = random.nextInt(60, 100);
                boolean isNotMatches = true;
                for (int number : intArray) {
                    if (number == num) {
                        isNotMatches = false;
                        break;
                    }
                }

                if (isNotMatches) {
                    intArray[i] = num;
                }
            }
        }
        Arrays.sort(intArray);
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) % 10 > 0 ? intArray[i] + " " : intArray[i] + "\n");
        }

        System.out.println("\n6. Копирование не пустых строк");
        String[] firstStringArray = {" ", "AA", "", "BBB", "CC", "D", " ", "E", "FF", "G", ""};
        int counterBlankString = 0;
        for (String string : firstStringArray) {
            if (string.isBlank()) {
                counterBlankString++;
            }
        }

        length = firstStringArray.length;
        String[] secondBlankString = new String[length - counterBlankString];
        int scrPos = 0;
        int destPos = 0;
        while (scrPos < length) {
            for (int i = scrPos; i < length; i++) {
                if (firstStringArray[i].isBlank()) {
                    int pieceLength = i - scrPos;
                    System.arraycopy(firstStringArray, scrPos, secondBlankString, destPos, pieceLength);
                    destPos += pieceLength;
                    scrPos = i + 1;
                }
            }
        }
        printStringArray(firstStringArray);
        printStringArray(secondBlankString);
    }

    private static void printIntArray(int[] intArray){
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(double[] doubleArray){
        for (double num : doubleArray) {
            System.out.printf("%6.3f ", num);
        }
        System.out.println();
    }

    private static void printStringArray(String[] stringArray) {
        for (String string : stringArray) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
}