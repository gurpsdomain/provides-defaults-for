package org.gupsdomain;

import java.util.*;

public class Provide {
    private final Map<String, Set<String>> provideDefault;

    public Provide() {
        provideDefault = new HashMap<String, Set<String>>();
    }

    public void register(Skill skill) {
        skill.registerIn(this);

    }

    public void registerDefaultFor(String skill, String aDefault) {
        if (!provideDefault.containsKey(aDefault)) {
            provideDefault.put(aDefault, new HashSet<String>());
        }
        provideDefault.get(aDefault).add(skill);
    }

    public Collection<String> defaultsFor(String aSkill) {
        return Collections.unmodifiableSet(provideDefault.getOrDefault(aSkill, new HashSet<String>()));
    }
}
