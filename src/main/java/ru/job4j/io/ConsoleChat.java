package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> phrases = readPhrases();
        Scanner input = new Scanner(System.in);
        System.out.println("Добро пожаловать. Введите ваш вопрос:");
        String text = input.nextLine();
        String answerBot = "";
        log.add(System.lineSeparator() + text);
        boolean working = true;
        while (!OUT.equals(text)) {
            if (working) {
                if (STOP.equals(text)) {
                    working = false;
                } else {
                    answerBot = phrases.get(new Random().nextInt(phrases.size() - 1));
                    System.out.print(answerBot);
                    log.add(answerBot);
                }
                text = input.nextLine();
                log.add(text);
            } else if (CONTINUE.equals(text)) {
                answerBot = phrases.get(new Random().nextInt(phrases.size() - 1));
                System.out.print(answerBot);
                log.add(answerBot);
                text = input.nextLine();
                log.add(text);
                working = true;
            } else {
                text = input.nextLine();
                log.add(text);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers))) {
            reader.lines()
                    .map(string -> string + System.lineSeparator())
                    .forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("UTF-8"), true))) {
         log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("data/logChat.txt", "data/botAnswers.txt");
        consoleChat.run();
    }
}