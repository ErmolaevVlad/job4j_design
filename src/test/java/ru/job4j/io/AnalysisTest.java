package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.*;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnalysisTest {
    @Test
    void analysis(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter output = new PrintWriter(source)) {
            output.println("200 10:56:01");
            output.println("300 10:57:01");
            output.println("400 10:58:01");
            output.println("500 10:59:02");
            output.println("300 11:01:01");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getPath(), target.getPath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(target))) {
            input.lines().forEach(result::append);
        }
        assertThat("10:58:01;11:01:01").hasToString(result.toString());
    }

}