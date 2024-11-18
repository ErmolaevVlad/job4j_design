package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            input.lines().forEach(rsl::add);
            rsl.removeIf(s -> !s.split(" ")[s.split(" ").length - 2].contains("404"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void saveTo(String out) {
        var data = filter();
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)
                )
        )) {
           data.forEach(output::println);
        } catch (IOException e) {
            e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        new LogFilter("data/log.txt").saveTo("data/out.txt");
    }
}

