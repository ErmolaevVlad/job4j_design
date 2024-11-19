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
        String[] str;
        try (BufferedReader input = new BufferedReader(new FileReader(file))) {
            input.lines().filter(s -> s.contains(" 404 ")).forEach(rsl::add);
            for (int index = 0; index < rsl.size(); index++) {
                str = rsl.get(index).split(" ");
                if (!str[str.length - 2].equals("404")) {
                    rsl.remove(index);
                    index--;
                }
            }
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

