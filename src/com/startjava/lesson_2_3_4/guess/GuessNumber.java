package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;
import java.util.Random;

class GuessNumber {

    private final Player player1;
    private final Player player2;
    private int hiddenNumber;

    public GuessNumber(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void launch() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        hiddenNumber = random.nextInt(100) + 1;
        System.out.println("У каждого игрока по " + Player.CAPACITY + " попыток");

        do {
            System.out.print(player1.getName() + ", введите число: ");
            player1.setNumber(sc.nextInt());

            if (isGuessed(player1)) {
                break;
            }

            System.out.print(player2.getName() + ", введите число: ");
            player2.setNumber(sc.nextInt());
        } while (!isGuessed(player2) && (player1.getAttempts() > 0) && (player2.getAttempts() > 0));

        printNumbers(player1);
        printNumbers(player2);
        player1.clear();
        player2.clear();
    }

    private boolean isGuessed(Player player) {
        int number = player.getNumber();
        player.setAttempts(player.getAttempts() - 1);
        if (number == hiddenNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + hiddenNumber +
                    " c " + (Player.CAPACITY - player.getAttempts()) + " попытки");
            return true;
        }

        String state = (number > hiddenNumber ? "больше" : "меньше");
        System.out.printf("Число %d %s того, что загадал компьютер%n", number, state);
        if (player.getAttempts() == 0) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
        return false;
    }

    public void printNumbers(Player player) {
        int[] numbers = player.getNumbers();
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}