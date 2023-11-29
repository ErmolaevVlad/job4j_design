package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .doesNotContain("box");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isNotEmpty();
    }

    @Test
    void whenNumberOfVertices4() {
        Box box = new Box(4, 6);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4)
                .isLessThan(7);
    }

    @Test
    void whenNumberOfVertices0() {
        Box box = new Box(0, 20);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(0)
                .isBetween(-2, 2);
    }

    @Test
    void whenExist() {
        Box box = new Box(4, 6);
        boolean rsl = box.isExist();
        assertThat(rsl).isTrue();
    }

    @Test
    void whenNotExist() {
        Box box = new Box(3, 6);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }

    @Test
    void whenArea62dot35() {
        Box box = new Box(4, 6);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(62.35d, withPrecision(0.01d))
                .isGreaterThan(60.2d);
    }

    @Test
    void whenArea0() {
        Box box = new Box(3, 6);
        double rsl = box.getArea();
        assertThat(rsl).isEqualTo(0d, withPrecision(0.01d))
                .isLessThan(2.2d);
    }

}