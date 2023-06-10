package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

class Player {

    public static final int CAPACITY = 10;
    private final String name;
    private int attempts = 0;
    private final int[] numbers = new int[CAPACITY];
    private int numberOfGuessed = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[attempts];
    }

    public void setNumber(int number) {
        if (number > 0 && number <= 100) {
            numbers[attempts] = number;
        }
    }

    public int getAttempts() {
        return attempts;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, attempts);
    }

    public int getNumberOfGuessed() {
        return numberOfGuessed;
    }

    public void addAttempt() {
        attempts++;
    }

    public void clear() {
        Arrays.fill(numbers, 0, attempts, 0);
        attempts = 0;
    }

    public void addNumberOfGuessed() {
        numberOfGuessed++;
    }

    public void clearNumberOfGuessed() {
        numberOfGuessed = 0;
    }
}