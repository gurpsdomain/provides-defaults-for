package org.gupsdomain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Skill {
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private List<Default> defaults;

    private Skill() { /* needed by JAXB */ }

    public Skill(String name, Default... defaults) {
        this.name = name;
        this.defaults = Arrays.asList(defaults);
    }

    public void registerIn(Provide provide) {
        for (Default aDefault : defaults) {
            aDefault.registerIn(provide, name);
        }
    }
}
