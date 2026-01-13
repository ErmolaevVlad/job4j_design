package ru.job4j.solid.isp;

public interface Musician {
    /**
     * Музыканты специализируются на разных инструментах.
     * Придется заглушать методы не относящиеся к музыканту
     */

    void playGuitar();

    void playPiano();

    void playDrum();
}
