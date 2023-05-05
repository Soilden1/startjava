package com.startjava.lesson_1.ultimate;

class MyFirstGame {

    public static void main(String[] args) {
        int hiddenNum = 50;
        int inputNum = 33;

        while (inputNum != hiddenNum) {
            String position;
            if (inputNum < hiddenNum) {
                position = "меньше";
                inputNum++;
            } else {
                position = "больше";
                inputNum--;
            }
            System.out.printf("Число %d %s того, что загадал компьютер%n", inputNum, position);
        }

        System.out.println("Вы победили!");
    }
}