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
        String delimiter = argsName.get("delimiter");

        try (Scanner scanner = new Scanner(Path.of(argsName.get("path"))).useDelimiter(delimiter)) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine().split(delimiter));
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
                    joiner.add(delimiter);
                } else {
                    joiner.add(System.lineSeparator());
                }
            }
        }
        if ("stdout".equals(argsName.get("out"))) {
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
        if (!"stdout".equals(argsName.get("out")) && (!argsName.get("out").endsWith(".csv"))) {
            throw new IllegalArgumentException("third parameter is incorrect or is not a directory");
        }
        if ((!";".equals(argsName.get("delimiter"))) && (!",".equals(argsName.get("delimiter")))) {
            throw new IllegalArgumentException("second parameter is incorrect");
        }
        handle(argsName);
    }
}