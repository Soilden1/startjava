package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

class GuessNumber {

    private final Player[] players;
    private int hiddenNumber;

    public GuessNumber(Player... players) {
        this.players = Arrays.copyOf(players, players.length);
    }

    public void launch() {
        Random random = new Random();
        castLots();
        int round = 0;
        while (round < 3) {
            round++;
            hiddenNumber = random.nextInt(100) + 1;
            System.out.printf("Начинается %d раунд%n", round);
            System.out.println("У каждого игрока по " + Player.CAPACITY + " попыток");

            int step = 0;
            while (isContinuing() && step < Player.CAPACITY) {
                step++;
            }

            for (Player player : players) {
                printNumbers(player);
                player.clear();
            }
        }
        determineWinner();
    }

    private void castLots() {
        Random random = new Random();
        for (int i = players.length - 1; i > 0; i--) {
            int randomNumber = random.nextInt(i + 1);
            Player tmp = players[i];
            players[i] = players[randomNumber];
            players[randomNumber] = tmp;
        }
    }

    private boolean isContinuing() {
        for (Player player : players) {
            inputNumber(player);
            if (isGuessed(player)) {
                return false;
            }
        }
        return true;
    }

    private void inputNumber(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.print(player.getName() + ", введите число: ");
        int number = sc.nextInt();

        if (number > 0 && number <= 100) {
            player.setNumber(number);
        } else {
            System.out.println("Ошибка: вводите числа в интервале от 1 до 100");
            inputNumber(player);
        }
    }

    private boolean isGuessed(Player player) {
        int number = player.getNumber();
        player.addAttempt();

        if (number == hiddenNumber) {
            player.addNumberOfGuessed();
            System.out.println("Игрок " + player.getName() + " угадал число " + hiddenNumber +
                    " c " + (player.getAttempts()) + " попытки");
            return true;
        }

        System.out.printf("Число %d %s того, что загадал компьютер%n", number, number > hiddenNumber ? "больше" : "меньше");
        if (player.getAttempts() == Player.CAPACITY) {
            System.out.println("У " + player.getName() + " закончились попытки");
        }
        return false;
    }

    private void printNumbers(Player player) {
        int[] numbers = player.getNumbers();
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    private void determineWinner() {
        int maxGuessed = 0;
        int winnerIndex = 0;
        int countWinners = 0;

        for (int i = 0; i < players.length; i++) {
            int guessed = players[i].getNumberOfGuessed();
            if (guessed > maxGuessed) {
                maxGuessed = guessed;
                winnerIndex = i;
                countWinners = 1;
            } else if (guessed == maxGuessed) {
                countWinners = 0;
            }
            players[i].clearNumberOfGuessed();
        }

        if (countWinners == 1) {
            System.out.println("По результатам трех раундов победил " + players[winnerIndex].getName());
        } else {
            System.out.println("Победитель не определен");
        }
    }
}