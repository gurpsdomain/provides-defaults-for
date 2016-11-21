package org.gurpsdomain;

import org.gupsdomain.Default;
import org.gupsdomain.Provide;
import org.gupsdomain.Skill;
import org.gupsdomain.Type;
import org.junit.Test;

import java.util.Collection;

import static junit.framework.TestCase.assertTrue;

public class ProvideTest {
    @Test
    public void shouldProvideDefaultsForSkill() {
        Provide provide = new Provide();
        provide.register(new Skill("A", new Default("B", -1, Type.Skill)));

        Collection<String> defaults = provide.defaultsFor("B");

        assertTrue(defaults.contains("A"));
    }

    @Test
    public void shouldProvideDefaultsOnlyForOtherSkills() {
        Provide provide = new Provide();
        provide.register(new Skill("A", new Default(-1, Type.IQ)));

        Collection<String> defaults = provide.defaultsFor("B");

        assertTrue(defaults.isEmpty());
    }

}
