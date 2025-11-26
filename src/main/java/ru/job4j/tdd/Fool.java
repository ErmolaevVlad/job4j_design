package ru.job4j.tdd;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        Fool fool = new Fool();
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(fool.check(startAt));
            startAt++;
            if (!input.nextLine().equals(fool.check(startAt))) {
                System.out.println("Ошибка. Начинай снова.");
                startAt = 0;
            }
            startAt++;
        }
    }

    public String check(int startAt) {
        String rsl = String.valueOf(startAt);
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            rsl = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            rsl = "Fizz";
        } else if (startAt % 5 == 0) {
            rsl = "Buzz";
        }
        return rsl;
    }
}
