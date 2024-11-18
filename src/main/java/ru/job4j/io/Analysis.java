package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        boolean works = true;
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
                BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            reader.lines().forEach(list::add);
            for (String str : list) {
                if ((str.split(" ")[0].equals("400") || str.split(" ")[0].equals("500"))
                        && works) {
                    output.append(str.split(" ")[1]);
                    works = false;
                } else if (!(str.split(" ")[0].equals("400") || str.split(" ")[0].equals("500"))
                        && !works) {
                    output.append(";").append(str.split(" ")[1]).append("\n");
                    works = true;
                }
            }
            writer.write(output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}