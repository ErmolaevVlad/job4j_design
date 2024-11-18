package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader =  new BufferedReader(new FileReader(this.path))) {
            List<String> list = new ArrayList<>();
            reader.lines().forEach(list::add);
            for (String str : list) {
                if (!str.startsWith("=")
                        && str.split("=").length > 1
                        && str.contains("=")) {
                    values.put(str.split("=", 2)[0], str.split("=", 2)[1]);
                } else if (!str.startsWith("#")) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("data/app.properties"));
    }
}
