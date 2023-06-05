package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import static com.startjava.lesson_2_3_4.guess.Player.STARTING_ATTEMPTS;

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
        player1.setAttempts(STARTING_ATTEMPTS);
        player2.setAttempts(STARTING_ATTEMPTS);
        System.out.println("У каждого игрока по " + STARTING_ATTEMPTS + " попыток");

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
        clearNumbers(player1);
        clearNumbers(player2);
    }

    private boolean isGuessed(Player player) {
        int number = player.getNumber();
        int[] numbers = Arrays.copyOf(player.getNumbers(), STARTING_ATTEMPTS);
        numbers[player.getNumbers().length] = number;
        player.setNumbers(numbers);
        player.setAttempts(player.getAttempts() - 1);
        if (number == hiddenNumber) {
            System.out.println("Игрок " + player.getName() + " угадал число " + hiddenNumber +
                    " c " + (STARTING_ATTEMPTS - player.getAttempts()) + " попытки");
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

    private void clearNumbers(Player player) {
        int[] numbers = player.getNumbers();
        Arrays.fill(numbers, 0);
        player.setNumbers(numbers);
    }
}