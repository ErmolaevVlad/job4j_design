package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkParameterParse() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("array is empty");

    }

    @Test
    void checkSymbol() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"1=Viktor", "2=Alex", "3:Ivan", "4=Pavel"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("the symbol '='")
                .hasMessageContaining("3:Ivan");
    }

    @Test
    void checkKey() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"1=Viktor", "2=Alex", "=Ivan", "4=Pavel"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .hasMessageContaining("not contain a key")
                .hasMessageContaining("=Ivan");
    }

    @Test
    void checkValue() {
        NameLoad nameLoad = new NameLoad();
        String[] names = {"1=Viktor", "2=Alex", "3=", "4=Pavel"};
        assertThatThrownBy(() -> nameLoad.parse(names))
                .hasMessageContaining("contain a value")
                .hasMessageContaining("3=");
    }
}