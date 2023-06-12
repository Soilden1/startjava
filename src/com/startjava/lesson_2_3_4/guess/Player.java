package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

class Player {

    public static final int CAPACITY = 10;
    private final String name;
    private final int[] numbers = new int[CAPACITY];
    private int attempts;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[attempts - 1];
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempts);
    }

    public int getAttempts() {
        return attempts;
    }

    public int getScore() {
        return score;
    }

    public void addNumber(int number) {
        if (number > 0 && number <= 100) {
            numbers[attempts++] = number;
        }
    }

    public void incScore() {
        score++;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempts, 0);
        attempts = 0;
    }

    public void clearScore() {
        score = 0;
    }
}