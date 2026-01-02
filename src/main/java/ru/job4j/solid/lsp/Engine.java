package ru.job4j.solid.lsp;

public class Engine {
    private int power;
    private float volume;

    public Engine(int power, float volume) {
        this.power = power;
        this.volume = volume;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }
}

class Bus {

    protected Engine engine;

    public Bus(Engine engine) {
        validate(engine);
        this.engine = engine;
    }

    public void validate(Engine engine) {
        if ((engine.getPower() <  210) && (engine.getVolume() < 4.4))  {
            throw new IllegalArgumentException("Sum must be greater than 0");
        }
        if ((engine.getPower() >  220) && (engine.getVolume() > 5.13))  {
            throw new IllegalArgumentException("Sum must be greater than 0");
        }
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        validate(engine);
        this.engine = engine;
    }
}

class LiAZ extends Bus {

    public LiAZ(Engine engine) {
        super(engine);
    }

    /**
     * Не сделана проверка, возможно получение не правильного двигателя
     * @param engine
     */
    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
