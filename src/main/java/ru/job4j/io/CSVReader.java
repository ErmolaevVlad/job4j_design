package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String[] line;
        List<Integer> columns = new ArrayList<>();
        List<String[]> list = new ArrayList<>();
        StringJoiner joiner = new StringJoiner("");

        try (Scanner scanner = new Scanner(Path.of(argsName.get("path"))).useDelimiter(argsName.get("delimiter"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine().split(argsName.get("delimiter")));
            }
        }
        System.out.println(list);
        line = list.get(0);
        for (String str : argsName.get("filter").split(",")) {
            for (int index = 0; index < line.length; index++) {
                if (str.equals(line[index])) {
                    columns.add(index);
                }
            }
        }
        for (String[] strings : list) {
            for (int column = 0; column < columns.size(); column++) {
                joiner.add(strings[columns.get(column)]);
                if (!(column + 1 == columns.size())) {
                    joiner.add(argsName.get("delimiter"));
                } else {
                    joiner.add(System.lineSeparator());
                }
            }
        }
        if (argsName.get("out").equals("stdout")) {
            System.out.println(joiner);
        } else {
            try (FileOutputStream output = new FileOutputStream(argsName.get("out"))) {
                output.write(joiner.toString().getBytes());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Incorrect number of parameters");
        }
        ArgsName argsName = ArgsName.of(args);
        if (!argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException("first parameter is incorrect");
        }
        if (!argsName.get("out").equals("stdout") && (!argsName.get("out").endsWith(".csv"))) {
            throw new IllegalArgumentException("third parameter is incorrect or is not a directory");
        }
        if ((!argsName.get("delimiter").equals(";")) && (!argsName.get("delimiter").equals(","))) {
            throw new IllegalArgumentException("second parameter is incorrect");
        }
        handle(argsName);
    }
}