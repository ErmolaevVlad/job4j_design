package ru.job4j.collection;

public class SimpleQueue<T> {

    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();

    int inputSize = 0;
    int outputSize = 0;

    public T poll() {
        if (outputSize == 0) {
            while (inputSize != 0) {
                output.push(input.pop());
                inputSize--;
                outputSize++;
            }
        }
        outputSize--;
        return output.pop();
    }

    public void push(T value) {
        input.push(value);
        inputSize++;
    }
}
