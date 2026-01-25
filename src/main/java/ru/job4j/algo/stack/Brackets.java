package ru.job4j.algo.stack;

import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        boolean rsl = true;
        Stack<Character> stack = new Stack<>();
        if (s != null && !s.isEmpty()) {
            for (int index = 0; index < s.length(); index++) {
                if (s.charAt(index) == '(' || s.charAt(index) == '{' || s.charAt(index) == '[') {
                    stack.push(s.charAt(index));
                } else {
                    if (stack.isEmpty()) {
                         rsl = false;
                         break;
                    }
                    if (s.charAt(index) == ')' && stack.peek() == '(') {
                        stack.pop();
                    }
                    if (s.charAt(index) == '}' && stack.peek() == '{') {
                        stack.pop();
                    }
                    if (s.charAt(index) == ']' && stack.peek() == '[') {
                        stack.pop();
                    }
                }
            }
        }
        if (rsl && !stack.isEmpty()) {
            rsl = false;
        }
        return rsl;
    }
}