package com.startjava.lesson_2_3_4.guess;

import java.util.Scanner;

class GuessNumberTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Введите имя первого игрока: ");
        Player player1 = new Player(sc.next());
        System.out.print("Введите имя второго игрока: ");
        Player player2 = new Player(sc.next());
        System.out.print("Введите имя третьего игрока: ");
        Player player3 = new Player(sc.next());

        String continuation = "yes";
        while (!continuation.equals("no")) {
            if (continuation.equals("yes")) {
                GuessNumber game = new GuessNumber(player1, player2, player3);
                game.launch();
            }

            System.out.println("Хотите продолжить игру? [yes/no]");
            continuation = sc.next();
        }
    }
}