package dev.tonimatas.litefun.skillsystem.stat;

public class Stat {
    private final String name;
    private final double value;

    public Stat(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
