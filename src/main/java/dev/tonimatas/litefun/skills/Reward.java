package dev.tonimatas.litefun.skills;

public class Reward {
    private final String id;
    private final int levels;
    private final int startLevel;
    private final int endLevel;

    public Reward(String id, int levels, int startLevel, int endLevel) {
        this.id = id;
        this.levels = levels;
        this.startLevel = startLevel;
        this.endLevel = endLevel;
    }

    public String getId() { return id; }
    public int getLevels() { return levels; }
    public int getStartLevel() { return startLevel; }
    public int getEndLevel() { return endLevel; }
}
