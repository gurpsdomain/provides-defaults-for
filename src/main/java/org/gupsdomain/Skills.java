package org.gupsdomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Iterator;
import java.util.List;

@XmlRootElement(name="skill_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Skills implements Iterable<Skill> {
    @XmlElement(required = true)
    private List<Skill> skills;

    @Override
    public Iterator<Skill> iterator() {
        return skills.iterator();
    }
}
