package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toString()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean checkArgs(ArgsName args) {
        if (!Files.isDirectory(Path.of(args.get("d")))) {
            throw new IllegalArgumentException("The first parameter is not a directory");
        }
        if (!args.get("e").startsWith(".")) {
            throw new IllegalArgumentException("The second parameter is incorrect");
        }
        if (!args.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("The third second parameter is incorrect");
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );

        if (args.length != 3) {
            throw new IllegalArgumentException("Incorrect number of parameters");
        }
        Zip zipFiles = new Zip();
        ArgsName argsName = ArgsName.of(args);
        if (checkArgs(argsName)) {
            zipFiles.packFiles(Search.search(Path.of(argsName.get("d")),
                    path -> !path.toFile().getName().endsWith(argsName.get("e"))), new File(argsName.get("o")));
        }
    }
}