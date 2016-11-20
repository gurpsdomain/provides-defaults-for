package org.gurpsdomain;

import org.gupsdomain.Skills;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class SkillsTest {
    private static Unmarshaller unmarshaller;

    @BeforeClass
    public static void createUnMarshaller() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Skills.class);
        unmarshaller = context.createUnmarshaller();
    }

    private Skills skills;

    @Before
    public void unmarshallAdvantages() throws JAXBException {
        skills = (Skills) unmarshaller.unmarshal(new File("src/main/resources/skills.basic-set.xml"));
    }

    @Test
    public void shouldUnmarshallCorrectly() {
        assertThat(skills, is(not(nullValue())));
    }
}
