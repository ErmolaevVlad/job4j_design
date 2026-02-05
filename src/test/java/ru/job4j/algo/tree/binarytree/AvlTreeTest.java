package ru.job4j.algo.tree.binarytree;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AvlTreeTest {

    @Test
    void symmetricalOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 1; i < 8; i++) {
            tree.insert(i);
        }
        List<Integer> list = tree.inSymmetricalOrder();
        assertThat(list).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }

   @Test
    void preOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.insert(element);
        }
       assertThat(tree.inPreOrder()).hasSize(7)
               .containsExactly(4, 2, 1, 3, 6, 5, 7);
   }

    @Test
    void postOrderIsOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.insert(element);
        }
        assertThat(tree.inPostOrder()).hasSize(7)
                .containsExactly(1, 3, 2, 5, 7, 6, 4);
    }

    @Test
    void whenAddMaximumNotEndThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 8, 7}) {
            tree.insert(element);
        }
        assertThat(tree.maximum()).isEqualTo(8);
    }

    @Test
    void whenAddMaximumIsEndThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 1, 3, 5, 7}) {
            tree.insert(element);
        }
        assertThat(tree.maximum()).isEqualTo(7);
    }

    @Test
    void whenAddMinimumIsEndThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7, 1}) {
            tree.insert(element);
        }
        assertThat(tree.minimum()).isEqualTo(1);
    }

    @Test
    void whenAddMinimumIsNotEndThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{4, 2, 6, 3, 5, 7 }) {
            tree.insert(element);
        }
        assertThat(tree.minimum()).isEqualTo(2);
    }

    @Test
    void whenRemoveKeyThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{2, 1, 10, 6, 14, 4, 8, 12, 16, 11, 9, 13, 15, 17, 3, 5, 7}) {
            tree.insert(element);
        }
        assertThat(tree.remove(6)).isTrue();
        assertThat(tree.inPreOrder()).hasSize(16)
                .containsExactly(10, 5, 2, 1, 4, 3, 8, 7, 9, 14, 12, 11, 13, 16, 15, 17);
    }

    @Test
    void whenLeftRotationThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{23, 10, 50, 4, 14, 34, 78, 1, 9, 12, 17, 31, 41, 68, 85}) {
            tree.insert(element);
        }
        tree.remove(1);
        tree.remove(4);
        tree.remove(9);
        tree.remove(14);
        tree.remove(12);
        tree.remove(17);
        assertThat(tree.inPostOrder())
                .containsExactly(10, 31, 41, 34, 23, 68, 85, 78, 50);
    }

    @Test
    void whenRightRotationThenOk() {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int element : new int[]{23, 10, 50, 4, 14, 34, 78, 1, 9, 12, 17, 31, 41, 68, 85}) {
            tree.insert(element);
        }
        tree.remove(85);
        tree.remove(78);
        tree.remove(68);
        tree.remove(34);
        tree.remove(31);
        tree.remove(41);
        assertThat(tree.inPostOrder())
                .containsExactly(1, 9, 4, 12, 10, 17, 50, 23, 14);
    }

}