package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void  whenRemoveIf() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Predicate<Integer> predicate = value -> value > 4;
        ListUtils.removeIf(input, predicate);
        assertThat(input).hasSize(4).containsSequence(1, 2, 3, 4);
    }

    @Test
    void whenReplaceIf() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Predicate<Integer> predicate = value -> value < 3;
        ListUtils.replaceIf(input, predicate, 9);
        assertThat(input).containsSequence(9, 9, 3, 4, 5, 6, 7, 8);
    }

    @Test
    void whenReplaceIfWithEmptyList() {
        input = new ArrayList<>();
        Predicate<Integer> predicate = value -> value < 3;
        assertThatThrownBy(() -> ListUtils.replaceIf(input, predicate, 9))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenRemoveAll() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> elements = new ArrayList<>(Arrays.asList(3, 5, 6));
        ListUtils.removeAll(input, elements);
        assertThat(input).containsSequence(1, 2, 4, 7, 8);
    }

    @Test
    void whenReplaceAllWithEmptyList() {
        input = new ArrayList<>();
        List<Integer> elements = new ArrayList<>(Arrays.asList(3, 5, 6));
        assertThatThrownBy(() -> ListUtils.removeAll(input, elements))
                .isInstanceOf(NoSuchElementException.class);
    }
}