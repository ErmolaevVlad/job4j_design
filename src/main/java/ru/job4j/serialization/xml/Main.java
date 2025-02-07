package ru.job4j.serialization.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }

        final Company company = new Company("Cactus", true, new Contact("72-23-32"),
                new String[]{"construction", "property management"});
        JAXBContext contextCompany = JAXBContext.newInstance(Company.class);
        Marshaller marshallerCompany = contextCompany.createMarshaller();
        marshallerCompany.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xmlCompamy = "";
        try (StringWriter writer = new StringWriter()) {
            marshallerCompany.marshal(company, writer);
            xmlCompamy = writer.getBuffer().toString();
            System.out.println(xmlCompamy);
        }

        Unmarshaller unmarshallCompany = contextCompany.createUnmarshaller();
        try (StringReader stringReader = new StringReader(xmlCompamy)) {
            Company resultCompany = (Company) unmarshallCompany.unmarshal(stringReader);
            System.out.println(resultCompany);
        }
    }
}