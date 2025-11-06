package ru.job4j.cache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path filePath = Paths.get(cachingDir, "//", key);
        String content = null;
        try {
            if (isFileExist(filePath)) {
                content = Files.readString(filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    private boolean isFileExist(Path filePath) {
        if (!filePath.toFile().exists()) {
            System.out.println("File doesn't exist");
            return false;
        }
        if (!filePath.toString().endsWith(".txt")) {
            System.out.println("Illegal target file extension");
            return false;
        }
        return true;
    }
}