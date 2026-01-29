package ru.job4j.algo.tree;

import ru.job4j.collection.SimpleQueue;

import java.util.LinkedList;
import java.util.List;

public class TreeUtils<T> {
    /**
     * Метод выполняет обход дерева и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("root must be not null");
        }
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        int rsl = 0;
        queue.push(root);
        while (!queue.isEmpty()) {
            rsl++;
            for (Node<T> node : queue.poll().getChildren()) {
                queue.push(node);
            }
        }
        return rsl;
    }

    /**
     * Метод выполняет обход дерева и возвращает коллекцию ключей узлов дерева
     * @param root корневой узел
     * @return коллекция с ключами, реализующая интерфейс Iterable<E>
     * @throws IllegalArgumentException если root является null
     */
    public Iterable<T> findAll(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException("root must be not null");
        }
        SimpleQueue<Node<T>> queue = new SimpleQueue<>();
        List<T> rsl = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node<T> subNode = queue.poll();
            rsl.add(subNode.getValue());
            for (Node<T> node : subNode.getChildren()) {
                queue.push(node);
            }
        }
        return rsl;
    }
}
