package ru.job4j.serialization.json;

import java.util.Arrays;

public class Company {
    private final String name;
    private final boolean open;
    private final Contact contact;
    private final String[] fieldOfActivity;

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

    public String getName() {
        return name;
    }

    public boolean getOpen() {
        return open;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getFieldOfActivity() {
        return fieldOfActivity;
    }
}
