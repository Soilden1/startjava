package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;
import java.util.Random;

class GuessNumber {

    private static final int ROUNDS = 3;
    private final Player[] players;
    private int hiddenNumber;

    public GuessNumber(Player... players) {
        this.players = players;
    }

    public void launch() {
        Random random = new Random();
        castLots();
        for (int i = 0; i < ROUNDS; i++) {
            hiddenNumber = random.nextInt(Player.MAX_NUMBER) + 1;
            System.out.printf("Начинается %d раунд%n", i + 1);
            System.out.println("У каждого игрока по " + Player.CAPACITY + " попыток");

            int step = 0;
            while (isGuessed() && step < Player.CAPACITY) {
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

    private boolean isGuessed() {
        for (Player player : players) {
            inputNumber(player);
            if (compareNumbers(player)) {
                return false;
            }
        }
        return true;
    }

    private void inputNumber(Player player) {
        Scanner sc = new Scanner(System.in);
        System.out.print(player.getName() + ", введите число: ");
        int number = sc.nextInt();

        if (!player.addNumber(number)) {
            System.out.println("Ошибка: вводите числа в интервале от 1 до 100");
            inputNumber(player);
        }
    }

    private boolean compareNumbers(Player player) {
        int number = player.getNumber();

        if (number == hiddenNumber) {

            player.incScore();
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
        int maxScore = 0;
        int winnerIndex = 0;
        int countWinners = 0;

        for (int i = 0; i < players.length; i++) {
            int score = players[i].getScore();
            if (score > maxScore) {
                maxScore = score;
                winnerIndex = i;
                countWinners = 1;
            } else if (score == maxScore) {
                countWinners = 0;
            }
            players[i].clearScore();
        }

        if (countWinners == 1) {
            System.out.println("По результатам трех раундов победил " + players[winnerIndex].getName());
        } else {
            System.out.println("Победитель не определен");
        }
    }
}