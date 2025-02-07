package ru.job4j.serialization.xml;

import jakarta.xml.bind.annotation.*;

import java.util.Arrays;

@XmlRootElement(name = "company")
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private boolean open;
    private Contact contact;
    private String[] fieldOfActivity;

    public Company() { }

    public Company(String name, boolean open, Contact contact, String[] fieldOfActivity) {
        this.name = name;
        this.open = open;
        this.contact = contact;
        this.fieldOfActivity = fieldOfActivity;
    }

    @Override
    public String toString() {
        return "Company{"
                + "name=" + name
                + ", open=" + open
                + ", contact=" + contact
                + ", activity=" + Arrays.toString(fieldOfActivity)
                + '}';
    }
}
