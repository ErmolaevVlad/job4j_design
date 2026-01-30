package ru.job4j.algo.tree;

import ru.job4j.collection.SimpleQueue;
import ru.job4j.collection.SimpleStack;

import java.util.*;

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

    /**
     * Метод обходит дерево root и добавляет к узлу с ключом parent
     * новый узел с ключом child, при этом на момент добавления узел с ключом parent
     * уже должен существовать в дереве, а узла с ключом child в дереве быть не должно
     * @param root корень дерева
     * @param parent ключ узла-родителя
     * @param child ключ узла-потомка
     * @return true если добавление произошло успешно и false в обратном случае.
     * @throws IllegalArgumentException если root является null
     */
    public boolean add(Node<T> root, T parent, T child) {
        if (root == null) {
            throw new IllegalArgumentException("root must be not null");
        }
        boolean rsl = false;
        Optional<Node<T>> parentNode = findByKey(root, parent);
        Optional<Node<T>> childNode = findByKey(root, child);
        if (parentNode.isPresent() && childNode.isEmpty()) {
           parentNode.get().getChildren().add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException("root must be not null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key must be not bull");
        }
        Optional<Node<T>> rsl = Optional.empty();
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> subNode = stack.pop();
            if (subNode.getValue().equals(key)) {
                rsl = Optional.of(subNode);
            }
            for (Node<T> node : subNode.getChildren()) {
                stack.push(node);
            }
        }
        return rsl;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key,
     * при этом из дерева root удаляется все поддерево найденного узла
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> divideByKey(Node<T> root, T key) {
        if (root == null) {
            throw new IllegalArgumentException("root must be not null");
        }
        if (key == null) {
            throw new IllegalArgumentException("key must be not bull");
        }
        Optional<Node<T>> rsl = Optional.empty();
        if (root.getValue().equals(key)) {
            rsl = Optional.of(root);
        } else {
            SimpleStack<Node<T>> stack = new SimpleStack<>();
            stack.push(root);
            while (!stack.isEmpty() && rsl.isEmpty()) {
                Node<T> subNode = stack.pop();
                Iterator<Node<T>> iterator = subNode.getChildren().iterator();
                while (iterator.hasNext()) {
                    Node<T> children = iterator.next();
                    if (children.getValue().equals(key)) {
                        iterator.remove();
                        rsl = Optional.of(children);
                        break;
                    } else {
                        stack.push(children);
                    }
                }
            }
        }
        return rsl;
    }
}
