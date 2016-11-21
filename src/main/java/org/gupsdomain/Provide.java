package org.gupsdomain;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Provide {
    @XmlElement(required = true)
    private final Map<String, Container> defaults;

    public Provide() {
        defaults = new HashMap<String, Container>();
    }

    public void register(Skill skill) {
        skill.registerIn(this);

    }

    public void registerDefaultFor(String skill, String aDefault) {
        if (!defaults.containsKey(aDefault)) {
            defaults.put(aDefault, new Container());
        }
        defaults.get(aDefault).add(skill);
    }

    public Collection<String> defaultOn(String aSkill) {
        return Collections.unmodifiableCollection(defaults.getOrDefault(aSkill, new Container()).skills);
    }
}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Container {
    @XmlElementWrapper(name = "skills")
    @XmlElement(name = "skill")
    public Set<String> skills = new HashSet<String>();

    public void add(String skill) {
        skills.add(skill);
    }
}