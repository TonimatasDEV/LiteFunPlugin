package dev.tonimatas.litefun.skills;

import java.util.List;

public class XPGainMethod {
    private final String trigger;
    private final double multiplier;
    private final List<String> filters;

    public XPGainMethod(String trigger, double multiplier, List<String> filters) {
        this.trigger = trigger;
        this.multiplier = multiplier;
        this.filters = filters;
    }

    public String getTrigger() { return trigger; }
    public double getMultiplier() { return multiplier; }
    public List<String> getFilters() { return filters; }
}
