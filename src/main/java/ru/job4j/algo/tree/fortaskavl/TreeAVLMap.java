package ru.job4j.algo.tree.fortaskavl;

import java.util.*;

public class TreeAVLMap<T extends Comparable<T>, V> {

    private Node root;

    private boolean contains(Node node, T key) {
        boolean rsl = false;
        if (root != null) {
            rsl = !(find(node, key) == null);
        }
        return rsl;
    }

    public boolean insert(T key, V value) {
        boolean rsl = false;
        if (Objects.nonNull(key) && Objects.nonNull(value)) {
            root = insert(root, key, value);
            rsl = true;
        }
        return rsl;
    }

    private Node insert(Node node, T key, V value) {
        Node rsl = new Node(key, value);
        if (Objects.nonNull(node)) {
            int comparisonResult = key.compareTo(node.key);
            if (comparisonResult < 0) {
                node.left = insert(node.left, key, value);
            } else if (comparisonResult > 0) {
                node.right = insert(node.right, key, value);
            } else {
                node = rsl;
            }
            updateHeight(node);
            rsl = balance(node);
        }
        return rsl;
     }

    private void updateHeight(Node node) {
        int leftNodeHeight = Objects.isNull(node.left) ? -1 : node.left.height;
        int rightNodeHeight = Objects.isNull(node.right) ? -1 : node.right.height;
        node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node balance(Node node) {
        Node result = node;
        if (node.balanceFactor < -1) {
            if (node.left.balanceFactor >= 0) {
                result = leftRightCase(node);
            } else {
                result = rightRotation(node);
            }
        } else if (node.balanceFactor > 1) {
            if (node.right.balanceFactor >= 0) {
                result = leftRotation(node);
            } else {
                result = rightLeftCase(node);
            }
        }
        return result;
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return rightRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return leftRotation(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        updateHeight(node);
        updateHeight(newParent);
        return newParent;
    }

    private Node rightRotation(Node node) {
        Node newParent = node.left;
        node.left = newParent.right;
        newParent.right = node;
        updateHeight(node);
        updateHeight(newParent);
        return newParent;
    }

    public boolean remove(T key) {
        boolean rsl = false;
        if (Objects.nonNull(key) && Objects.nonNull(root) && contains(root, key)) {
            root = remove(root, key);
            rsl = true;
        }
        return rsl;
    }

    private Node remove(Node node, T key) {
        if (node == null) {
            return null;
        }
        int comparisonResult = key.compareTo(node.key);
        if (comparisonResult < 0) {
            node.left = remove(node.left, key);
        } else if (comparisonResult > 0) {
            node.right = remove(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                if (node.left.height > node.right.height) {
                    T heir = maximum(node.left).key;
                    node.key = heir;
                    node.left = remove(node.left, heir);
                } else {
                    T heir = minimum(node.right).key;
                    node.key = heir;
                    node.right = remove(node.right, heir);
                }
            }
        }
        updateHeight(node);
        return balance(node);
    }

    public V get(T key) {
        V rsl = null;
        Node node = find(root, key);
        if (Objects.nonNull(node)) {
            rsl = node.value;
        }
        return rsl;
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

    public Set<T> keySet() {
        Set<T> rsl = new HashSet<>();
        Node node = root;
        return keySet(node, rsl);
    }

    private Set<T> keySet(Node node, Set<T> set) {
        if (node != null) {
            keySet(node.left, set);
            set.add(node.key);
            keySet(node.right, set);
        }
        return set;
    }

    public Collection<V> values() {
        Collection<V> rsl = new ArrayList<>();
        Node node = root;
        return values(node, rsl);
    }

    private Collection<V> values(Node node, Collection<V> list) {
        if (node != null) {
            values(node.left, list);
            list.add(node.value);
            values(node.right, list);
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

    private class Node {
        private int balanceFactor;
        private T key;
        private V value;
        private int height;
        private Node left;
        private Node right;

        Node(T key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}