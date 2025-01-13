package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<String>> mapFiles = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty currentFile = new FileProperty(attributes.size(), file.getFileName().toString());
        mapFiles.computeIfAbsent(currentFile, k -> new ArrayList<>()).add(file.toAbsolutePath().toString());
        return super.visitFile(file, attributes);
    }

    public Map<FileProperty, List<String>> getMapFiles() {
        return mapFiles;
    }
}