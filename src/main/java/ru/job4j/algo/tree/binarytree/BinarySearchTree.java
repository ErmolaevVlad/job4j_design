package ru.job4j.algo.tree.binarytree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public boolean put(T key) {
        boolean result;
        if (Objects.isNull(root)) {
            root = new Node(key);
            result = true;
        } else {
            result = put(root, key);
        }
        return result;
    }

    private boolean put(Node node, T key) {
        boolean rsl = false;
        Node newNode = new Node(key);
        if (newNode.key.compareTo(node.key) < 0) {
            if (node.left == null) {
                node.left = newNode;
                rsl = true;
            } else {
                rsl = put(node.left, key);
            }
        } else  if (newNode.key.compareTo(node.key) > 0) {
            if (node.right == null) {
            node.right = newNode;
            rsl = true;
            } else {
                rsl = put(node.right, key);
            }
        }
        return rsl;
    }

    public boolean contains(T key) {
        return !(find(root, key) == null);

    }

    private Node find(Node node, T key) {
        Node rsl = null;
        if (key.compareTo(node.key) == 0) {
            rsl = node;
        } else if (key.compareTo(node.key) < 0) {
            if (node.left != null) {
                rsl = find(node.left, key);
            }
        } else {
            if (node.right != null) {
                rsl = find(node.right, key);
            }
        }
        return rsl;
    }

    public boolean remove(T key) {
        /* Метод будет реализован в следующих уроках */
        return false;
    }

    public List<T> inSymmetricalOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inSymmetricalOrder(node, result);
    }

    private List<T> inSymmetricalOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPreOrder() {
        List<T> rsl = new ArrayList<>();
        Node node = root;
        return inPreOrder(node, rsl);
    }

    private List<T> inPreOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            list.add(localRoot.key);
            inPreOrder(localRoot.left, list);
            inPreOrder(localRoot.right, list);

        }
        return list;
    }

    public List<T> inPostOrder() {
        List<T> rsl = new ArrayList<>();
        Node node = root;
        return inPostOrder(node, rsl);
    }

    private List<T> inPostOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inPostOrder(localRoot.left, list);
            inPostOrder(localRoot.right, list);
            list.add(localRoot.key);

        }
        return list;
    }

    public T minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        Node rsl = node;
        if (node.left != null) {
            rsl = minimum(node.left);
        }
        return rsl;
    }

    public T maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        Node rsl = node;
        if (node.right != null) {
            rsl = maximum(node.right);
        }
        return rsl;
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
        }

        @Override
        public VisualNode getLeft() {
            return left;
        }

        @Override
        public VisualNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key.toString();
        }
    }
}