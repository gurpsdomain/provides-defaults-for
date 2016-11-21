package org.gupsdomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@XmlRootElement(name="skill_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Skills implements Iterable<Skill> {
    @XmlElement(required = true, name = "skill")
    private List<Skill> skills = new ArrayList<Skill>();

    @Override
    public Iterator<Skill> iterator() {
        return skills.iterator();
    }

    public void registerIn(Provide provide) {
        for (Skill skill : this) {
            provide.register(skill);
        }
    }
}
