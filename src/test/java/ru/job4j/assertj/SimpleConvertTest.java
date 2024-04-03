package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = List.of("first", "second", "second", "three", "four", "five", "six");
        assertThat(list).hasSize(7)
                .contains("second")
                .contains("four", Index.atIndex(4))
                .containsAnyOf("zero", "second", "six")
                .containsExactly("first", "second", "second", "three", "four", "five", "six")
                .doesNotContain("first", Index.atIndex(1))
                .startsWith("first", "second")
                .endsWith("five", "six");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = Set.of("first", "second", "three", "four", "five", "six");
        assertThat(set).hasSize(6)
                .contains("second").containsAnyOf("ten", "five", "seven")
                .doesNotContain("ten")
                .containsAnyOf("zero", "second", "six");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = Map.of(
                "first", 1, "second", 2,  "three", 3,
                "four", 4, "five", 5, "six", 6);
        assertThat(map).hasSize(6)
                .containsKeys("three", "five")
                .containsValues(1, 4, 5, 6)
                .containsOnlyKeys("first", "second", "three", "four", "five", "six")
                .doesNotContainKeys("ten", "seven")
                .containsEntry("five", 5);
    }
}