package com.startjava.lesson_2_3_4.array;

import java.util.Random;
import java.util.Arrays;

public class ArrayTheme {

    public static void main(String[] args) {
        numberOne();
        numberTwo();
        numberTree();
        numberFour();
        numberFive();
        numberSix();
    }

    public static void numberOne() {
        System.out.println("1. Реверс значений массива");
        int[] intArray = {3, 7, 1, 2, 6, 4, 5};
        print(intArray);
        int length = intArray.length;
        for (int i = 0; i < length; i++) {
            int tmp = intArray[i];
            length--;
            intArray[i] = intArray[length];
            intArray[length] = tmp;
        }
        print(intArray);
    }

    public static void numberTwo() {
        System.out.println("\n2. Вывод произведения элементов массива");
        int[] intArray = new int[10];
        int length = intArray.length;
        int prod = 1;
        for (int i = 0; i < length; i++) {
            intArray[i] = i;
            if (i > 0 && i < 9) {
                prod *= i;
                System.out.print(i);
                System.out.print(i < length - 2 ? " * " : " = " + prod + "\n");
            }
        }
        System.out.println(intArray[0] + "(index: 0) " + intArray[length - 1] + "(index: 9)");
    }

    public static void numberTree() {
        System.out.println("\n3. Удаление элементов массива");
        Random random = new Random();
        double[] doubleArray = new double[15];
        int length = doubleArray.length;
        for (int i = 0; i < length; i++) {
            doubleArray[i] = random.nextDouble(1);
        }
        print(doubleArray, length);

        int averageIndex = length / 2;
        double average = doubleArray[averageIndex];
        int countZeroedCells = 0;
        for (int i = 0; i < length; i++) {
            if (doubleArray[i] > average) {
                doubleArray[i] = 0;
                countZeroedCells++;
            }
        }
        print(doubleArray, length);
        System.out.println("Количество обнуленных ячеек: " + countZeroedCells);
    }

    public static void numberFour() {
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

    public static void numberFive() {
        System.out.println("\n5. Генерация уникальных чисел");
        int[] intArray = new int[30];
        int length = intArray.length;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            while (intArray[i] == 0) {
                int randomNumber = random.nextInt(60, 100);
                boolean isNotMatches = true;
                for (int number : intArray) {
                    if (number == randomNumber) {
                        isNotMatches = false;
                        break;
                    }
                }

                if (isNotMatches) {
                    intArray[i] = randomNumber;
                }
            }
        }
        Arrays.sort(intArray);
        for (int i = 0; i < length; i++) {
            System.out.print((i + 1) % 10 > 0 ? intArray[i] + " " : intArray[i] + "\n");
        }
    }

    public static void numberSix() {
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