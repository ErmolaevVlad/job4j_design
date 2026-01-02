package ru.job4j.solid.lsp;

public class Programmer {
    int experience;

    public Programmer(int experience) {
        this.experience = experience;
    }

    public boolean checkExperience(int experience) {
        int minExperience = 1;
        if (experience < minExperience) {
            throw new IllegalArgumentException("work experience must be 1");
        }
        return true;
    }
}

class SeniorProgrammer extends Programmer {

    public SeniorProgrammer(int experience) {
        super(experience);
    }

    /**
     * Происходит усиление предусловия
     * @param experience
     * @return true, если стаж удовлетворяет минимальному
     */
    public boolean checkExperience(int experience) {
        int minExperience = 5;
        if (experience < minExperience) {
            throw new IllegalArgumentException("work experience must be 5");
        }
        return true;
    }
}