package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (checkArgs(args)) {
            Path start = Paths.get(args[0]);
            search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static boolean checkArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("Incorrect number of parameters");
        }
       if (!Files.isDirectory(Path.of(args[0]))) {
           throw new IllegalArgumentException("The first parameter is not a directory");
       }
       if (!args[1].startsWith(".")) {
           throw new IllegalArgumentException("The second parameter is incorrect");
       }
       return true;
    }
}