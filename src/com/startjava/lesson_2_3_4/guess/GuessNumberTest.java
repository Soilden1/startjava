package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

class GuessNumberTest {

    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Player[] players = createPlayers(sc);
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

    private static Player[] createPlayers(Scanner sc) {
        Player[] players = new Player[MAX_PLAYERS];
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.printf("Введите имя %d-ого игрока: ", i + 1);
            players[i] = new Player(sc.next());
        }
        return players;
    }
}