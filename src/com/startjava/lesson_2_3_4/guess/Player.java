package com.startjava.lesson_2_3_4.guess;

import java.util.Arrays;

class Player {

    public static final int CAPACITY = 10;
    private final String name;
    private int attempts = CAPACITY;
    private final int[] numbers = new int[CAPACITY];

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return numbers[CAPACITY - attempts];
    }

    public void setNumber(int number) {
        numbers[CAPACITY - attempts] = number;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int[] getNumbers() {
        return Arrays.copyOf(numbers, CAPACITY - attempts);
    }

    public void clear() {
        Arrays.fill(numbers, 0, CAPACITY - attempts, 0);
        attempts = CAPACITY;
    }
}