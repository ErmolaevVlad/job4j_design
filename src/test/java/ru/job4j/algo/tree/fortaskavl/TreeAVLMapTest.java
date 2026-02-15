package ru.job4j.algo.tree.fortaskavl;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

class TreeAVLMapTest {

    @Test
    void whenEmptyTree() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        assertThat(tree.values()).isEmpty();
        assertThat(tree.keySet()).isEmpty();
    }

    @Test
    void whenAddOneElemThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        assertThat(tree.insert(1, "11")).isTrue();
        assertThat(tree.values()).hasSize(1)
                .containsExactly("11");
        assertThat(tree.keySet()).hasSize(1)
                .containsExactly(1);
    }

    @Test
    void whenAddSevenElemThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        assertThat(tree.insert(1, "11")).isTrue();
        assertThat(tree.insert(2, "22")).isTrue();
        assertThat(tree.insert(3, "33")).isTrue();
        assertThat(tree.insert(4, "44")).isTrue();
        assertThat(tree.insert(5, "55")).isTrue();
        assertThat(tree.insert(6, "66")).isTrue();
        assertThat(tree.insert(7, "77")).isTrue();
        assertThat(tree.values()).hasSize(7)
                .containsExactly("11", "22", "33", "44", "55", "66", "77");
        assertThat(tree.keySet()).hasSize(7)
                .containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void whenUpdateValueThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.insert(1, "11");
        tree.insert(2, "22");
        tree.insert(3, "33");
        tree.insert(4, "44");
        tree.insert(5, "55");
        tree.insert(6, "66");
        tree.insert(7, "77");
        assertThat(tree.insert(5, "555")).isTrue();
        assertThat(tree.values()).hasSize(7)
                .containsExactly("11", "22", "33", "44", "555", "66", "77");
        assertThat(tree.keySet()).hasSize(7)
                .containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

    @Test
    void whenDeleteKeyThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.insert(1, "11");
        tree.insert(2, "22");
        tree.insert(3, "33");
        tree.insert(4, "44");
        tree.insert(5, "55");
        tree.insert(6, "66");
        tree.insert(7, "77");
        assertThat(tree.remove(5)).isTrue();
        assertThat(tree.remove(0)).isFalse();
        assertThat(tree.values()).hasSize(6)
                .containsExactly("11", "22", "33", "44", "66", "77");
        assertThat(tree.keySet()).hasSize(6)
                .containsExactly(1, 2, 3, 4, 6, 7);
    }

    @Test
    void whenGetKeyThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.insert(1, "11");
        tree.insert(2, "22");
        tree.insert(3, "33");
        tree.insert(4, "44");
        tree.insert(5, "55");
        tree.insert(6, "66");
        tree.insert(7, "77");
        assertThat(tree.get(5)).isEqualTo("55");
        assertThat(tree.get(0)).isNull();
    }

    @Test
    void whenLeftRotationThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.insert(23, "230");
        tree.insert(10, "100");
        tree.insert(50, "500");
        tree.insert(4, "40");
        tree.insert(14, "140");
        tree.insert(34, "340");
        tree.insert(78, "780");
        tree.insert(1, "10");
        tree.insert(9, "90");
        tree.insert(12, "120");
        tree.insert(17, "170");
        tree.insert(31, "310");
        tree.insert(41, "410");
        tree.insert(68, "680");
        tree.insert(85, "850");
        tree.remove(1);
        tree.remove(9);
        tree.remove(4);
        tree.remove(17);
        tree.remove(12);
        tree.remove(14);
        Collection<String> set = tree.values();
        assertThat(set)
                .containsExactly("100", "230", "310", "340", "410", "500", "680", "780", "850");
    }

    @Test
    void whenRightRotationThenOk() {
        TreeAVLMap<Integer, String> tree = new TreeAVLMap<>();
        tree.insert(23, "230");
        tree.insert(10, "100");
        tree.insert(50, "500");
        tree.insert(4, "40");
        tree.insert(14, "140");
        tree.insert(34, "340");
        tree.insert(78, "780");
        tree.insert(1, "10");
        tree.insert(9, "90");
        tree.insert(12, "120");
        tree.insert(17, "170");
        tree.insert(31, "310");
        tree.insert(41, "410");
        tree.insert(68, "680");
        tree.insert(85, "850");
        tree.remove(31);
        tree.remove(41);
        tree.remove(34);
        tree.remove(68);
        tree.remove(85);
        tree.remove(78);
        Collection<String> set = tree.values();
        assertThat(set)
                .containsExactly("10", "40", "90", "100", "120", "140", "170", "230", "500");
    }
}