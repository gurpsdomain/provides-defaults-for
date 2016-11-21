package org.gupsdomain;

import javax.xml.bind.annotation.XmlElement;

public class Default {
    @XmlElement(required = true)
    private Type type;
    @XmlElement(required = true)
    private int modifier;
    @XmlElement(required = false)
    private String name;

    public Default() { /* needed by JAXB */ }

    public Default(String name, int modifier, Type type) {
        this.name = name;
        this.modifier = modifier;
        this.type = type;
    }

    public Default(int modifier, Type type) {
        this.modifier = modifier;
        this.type = type;
    }

    public void registerIn(Provide provide, String skillName) {
        type.registerIn(provide, skillName, name);
    }
}

