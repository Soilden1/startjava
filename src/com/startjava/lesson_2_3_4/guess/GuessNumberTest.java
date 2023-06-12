//git fixed
package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

class GuessNumberTest {

    private static final int NUMBER_OF_PLAYERS = 3;
    private static final Player[] players = new Player[NUMBER_OF_PLAYERS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        createPlayers();
        String continuation = "yes";
        while (!continuation.equals("no")) {
            if (continuation.equals("yes")) {
                GuessNumber game = new GuessNumber(players);
                game.launch();
            }

            System.out.println("Хотите продолжить игру? [yes/no]");
            continuation = sc.next();
        }
    }

    private static void createPlayers() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            System.out.printf("Введите имя %d-ого игрока: ", i + 1);
            players[i] = new Player(sc.next());
        }
    }
}