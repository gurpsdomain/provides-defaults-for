package org.gupsdomain;

import javax.xml.bind.annotation.XmlElement;

public class Default {
    @XmlElement(required = true)
    private Type type;
    @XmlElement(required = true)
    private int modifier;
    @XmlElement(required = false)
    private String name;

}

enum Type {
    IQ, DX, HT, SKILL, Skill;
}