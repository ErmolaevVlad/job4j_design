package ru.job4j.algo.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintTree {

    private PrintTree() {
        throw new IllegalStateException("Utility class");
    }

    public static String getTreeDisplay(VisualNode root) {
        List<List<String>> lines = new ArrayList<>();
        int widest = collectNodes(root, lines);
        if (widest % 2 == 1) {
            widest++;
        }
        StringBuilder buffer = new StringBuilder();
        int perPiece = lines.get(lines.size() - 1).size() * (widest + 4);

        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            if (i > 0) {
                appendBranches(buffer, line, perPiece);
            }
            appendNodes(buffer, line, perPiece);
            perPiece /= 2;
        }
        return buffer.toString();
    }

    private static int collectNodes(VisualNode root, List<List<String>> lines) {
        List<VisualNode> level = new ArrayList<>();
        level.add(root);
        int nodeCount = 1;
        int widest = 0;
        while (nodeCount != 0) {
            List<String> line = new ArrayList<>();
            List<VisualNode> next = new ArrayList<>();
            nodeCount = 0;
            for (VisualNode node : level) {
                if (node == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String key = node.getText();
                    line.add(key);
                    if (key.length() > widest) {
                        widest = key.length();
                    }
                    next.add(node.getLeft());
                    if (node.getLeft() != null) {
                        nodeCount++;
                    }
                    next.add(node.getRight());
                    if (node.getRight() != null) {
                        nodeCount++;
                    }
                }
            }
            lines.add(line);
            level = next;
        }
        return widest;
    }

    private static void appendBranches(StringBuilder buffer, List<String> line, int perPiece) {
        int hpw = (int) Math.floor(perPiece / 2f) - 1;
        for (int i = 0; i < line.size(); i++) {
            char symbol = ' ';
            if (i % 2 == 1) {
                if (line.get(i - 1) != null) {
                    if (line.get(i) != null) {
                        symbol = '\u2534'; // ┴
                    } else {
                        symbol = '\u256F'; // ╯
                    }
                } else if (line.get(i) != null) {
                    symbol = '\u2570'; // ╰
                }
            }
            buffer.append(symbol);
            if (line.get(i) == null) {
                buffer.append(" ".repeat(Math.max(0, perPiece - 1)));
            } else {
                String sideSpace = (i % 2 == 0) ? " " : "\u2500";
                buffer.append(sideSpace.repeat(Math.max(0, hpw)));

                char corner = (i % 2 == 0) ? '\u256D' : '\u256E'; // ╭ : ╮
                buffer.append(corner);

                String innerSpace = (i % 2 == 0) ? "\u2500" : " ";
                buffer.append(innerSpace.repeat(Math.max(0, hpw)));
            }
        }
        buffer.append('\n');
    }

    private static void appendNodes(StringBuilder buffer, List<String> line, int perPiece) {
        for (String word : line) {
            if (word == null) {
                word = "";
            }
            double space = perPiece / 2f - word.length() / 2f;
            buffer.append(" ".repeat(Math.max(0, (int) Math.ceil(space))))
                    .append(word)
                    .append(" ".repeat(Math.max(0, (int) Math.floor(space))));
        }
        buffer.append('\n');
    }
}