package ru.job4j.solid.ocp;

public class Factory {

    /**
     * Необходим завод по производству стекла
     */
    public void factoryGlass () {
        System.out.println("glass production");
    }

    /**
     * Данные изменились:
     * необходим завод по производству кирпичей.
     */
    public void factoryBrick () {
        System.out.println("brick production");
    }

    /**
     * Данные опять изменились:
     * необходим завод по производству бумаги.
     * Происходит нарушение принципа открытости закрытости
     * требования могут постоянно изменяться и придется постоянно менять код
     */
    public void factoryPaper () {
        System.out.println("paper production");
    }

}
