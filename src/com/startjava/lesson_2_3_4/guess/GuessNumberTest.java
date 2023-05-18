package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuation = "yes";
        
        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(sc.next());
        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(sc.next());

        while (continuation.equals("yes")) {
            GuessNumber game = new GuessNumber(player1, player2);
            game.launch();

            do {
                System.out.println("Хотите продолжить игру? [yes/no]");
                continuation = sc.next();
            } while (!continuation.equals("yes") && !continuation.equals("no"));
        }
    }
}