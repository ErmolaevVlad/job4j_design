package ru.job4j.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoolTest {
    @Test
    void whenAnswerFizz() {
        Fool fool = new Fool();
        assertThat(fool.check(3)).isEqualTo("Fizz");
    }

    @Test
    void whenAnswerBuzz() {
        Fool fool = new Fool();
        assertThat(fool.check(5)).isEqualTo("Buzz");
    }

    @Test
    void whenAnswerFizzBuzz() {
        Fool fool = new Fool();
        assertThat(fool.check(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void whenAnswerNumber() {
        Fool fool = new Fool();
        assertThat(fool.check(14)).isEqualTo("14");
    }
}