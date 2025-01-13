package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("/home/v/Test/"), visitor);
        Map<FileProperty, List<String>> mapFiles = visitor.getMapFiles();
        for (Map.Entry<FileProperty, List<String>> entry : mapFiles.entrySet()) {
            List<String> path = entry.getValue();
            FileProperty key = entry.getKey();
            if (path.size() > 1) {
                StringBuilder builder = new StringBuilder();
                builder.append(key.getName()).append(" - ").append(key.getSize()).append(" byte:");
                System.out.println(builder);
                path.forEach(System.out::println);
                System.out.println();
            }
        }
    }
}