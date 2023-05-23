package com.startjava.lesson_2_3_4.array;

import java.util.Random;
import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        reverseArray();
        calculateProductElements();
        deleteElements();
        printReverseAlphabet();
        generateUniqueNumbers();
        copyNotBlankStrings();
    }

    public static void reverseArray() {
        System.out.println("1. Реверс значений массива");
        int[] intArray = {3, 7, 1, 2, 6, 4, 5};
        print(intArray);
        int length = intArray.length;
        for (int i = 0; i < length; i++) {
            int tmp = intArray[i];
            intArray[i] = intArray[--length];
            intArray[length] = tmp;
        }
        print(intArray);
    }

    public static void calculateProductElements() {
        System.out.println("\n2. Вывод произведения элементов массива");
        int[] multipliers = new int[10];
        int length = multipliers.length;
        int prod = 1;
        for (int i = 0; i < length; i++) {
            multipliers[i] = i;
            if (i > 0 && i < 9) {
                prod *= i;
                System.out.print(i);
                System.out.print(i < length - 2 ? " * " : " = " + prod + "\n");
            }
        }
        System.out.println(multipliers[0] + "(index: 0) " + multipliers[length - 1] + "(index: 9)");
    }

    public static void deleteElements() {
        System.out.println("\n3. Удаление элементов массива");
        Random random = new Random();
        double[] doubleArray = new double[15];
        int length = doubleArray.length;
        for (int i = 0; i < length; i++) {
            doubleArray[i] = random.nextDouble(1);
        }
        print(doubleArray, length);

        double middleCellValue = doubleArray[length / 2];
        int countZeroedCells = 0;
        for (int i = 0; i < length; i++) {
            if (doubleArray[i] > middleCellValue) {
                doubleArray[i] = 0;
                countZeroedCells++;
            }
        }
        print(doubleArray, length);
        System.out.println("Количество обнуленных ячеек: " + countZeroedCells);
    }

    public static void printReverseAlphabet() {
        System.out.println("\n4. Вывод элементов массива лесенкой в обратном порядке");
        char[] alphabet = new char[26];
        int length = alphabet.length;
        for (int i = 0; i < length; i++) {
            alphabet[i] = (char) ('A' + i);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(alphabet[length - 1 - j]);
            }
            System.out.println();
        }
    }

    public static void generateUniqueNumbers() {
        System.out.println("\n5. Генерация уникальных чисел");
        int[] uniqueNumbers = new int[30];
        int length = uniqueNumbers.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            while (uniqueNumbers[i] == 0) {
                int randomNumber = random.nextInt(60, 100);
                boolean isNotMatches = true;
                for (int number : uniqueNumbers) {
                    if (number == randomNumber) {
                        isNotMatches = false;
                        break;
                    }
                }

                if (isNotMatches) {
                    uniqueNumbers[i] = randomNumber;
                }
            }
        }
        Arrays.sort(uniqueNumbers);
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) % 10 > 0 ? uniqueNumbers[i] + " " : uniqueNumbers[i] + "\n");
        }
    }

    public static void copyNotBlankStrings() {
        System.out.println("\n6. Копирование не пустых строк");
        String[] srcStrings = {" ", "AA", "", "BBB", "CC", "D", " ", "E", "FF", "G", ""};
        int countNonBlankStrings = 0;
        for (String string : srcStrings) {
            if (string.isBlank()) {
                countNonBlankStrings++;
            }
        }

        int length = srcStrings.length;
        String[] destStrings = new String[length - countNonBlankStrings];
        int scrPos = 0;
        int destPos = 0;
        while (scrPos < length) {
            for (int i = scrPos; i < length; i++) {
                if (srcStrings[i].isBlank()) {
                    int pieceLength = i - scrPos;
                    System.arraycopy(srcStrings, scrPos, destStrings, destPos, pieceLength);
                    destPos += pieceLength;
                    scrPos = i + 1;
                }
            }
        }
        print(srcStrings);
        print(destStrings);
    }

    private static void print(int[] intArray) {
        for (int number : intArray) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private static void print(double[] doubleArray, int length) {
        for (int i = 0; i < length; i++) {
            System.out.printf("%6.3f ", doubleArray[i]);
            if (i == length / 2) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    private static void print(String[] stringArray) {
        for (String string : stringArray) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
}