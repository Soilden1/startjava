package com.startjava.lesson_2_3_4.person;

public class Person {

    String gender = "male";
    String name = "Ivan";
    int height = 180;
    int weight = 72;
    int age = 18;

    void move() {
        System.out.println("Человек идет");
    }

    void sit() {
        System.out.println("Человек сидит");
    }

    void run() {
        System.out.println("Человек бежит");
    }

    void talk() {
        System.out.println("Человек говорит");
    }

    void learnJava() {
        System.out.println("Человек учит Java");
    }
}

