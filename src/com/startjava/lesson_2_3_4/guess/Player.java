package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

class Player {

    public static final int STARTING_ATTEMPTS = 10;
    private final String name;
    private int number;
    private int attempts;
    private int[] numbers = new int[STARTING_ATTEMPTS];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, STARTING_ATTEMPTS - attempts);
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
}