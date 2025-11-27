package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GeneratorStringTest {

    @Test
    void whenReplacementIsSuccessful() {
        GeneratorString generatorString = new GeneratorString();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        args.put("subject", "you");
        assertThat(generatorString.produce(template, args)).isEqualTo("I am Alex, Who are you?");
    }

    @Test
    void whenKeyInTemplateOrInMapDoNotExist() {
        GeneratorString generatorString = new GeneratorString();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alex");
        args.put("subject", "you");
        assertThatThrownBy(() -> generatorString.produce(template, args)).isInstanceOf(IllegalArgumentException.class);
    }

}