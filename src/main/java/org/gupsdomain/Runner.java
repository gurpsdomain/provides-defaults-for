package org.gupsdomain;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Runner {
    public static void main(String[] args) throws JAXBException {
        Runner runner = new Runner("src/main/resources/skills.basic-set.xml");

        runner.convert("src/main/resources/defaults-for.basic-set.xml");
    }

    private final File inputFile;
    private final Unmarshaller unmarshaller;
    private final Marshaller marshaller;

    private Runner(String inputFileName) throws JAXBException {
        this.inputFile = new File(inputFileName);
        JAXBContext context = JAXBContext.newInstance(Skills.class, Provide.class);
        this.unmarshaller = context.createUnmarshaller();
        this.marshaller = context.createMarshaller();
    }


    private void convert(String outputFileName) throws JAXBException {
        Skills skills = (Skills) unmarshaller.unmarshal(inputFile);
        Provide provide = new Provide();
        provide.registerDefaultFor("b", "a");
        provide.registerDefaultFor("c", "a");


        skills.registerIn(provide);

        marshaller.marshal(provide, new File(outputFileName));
    }
}
