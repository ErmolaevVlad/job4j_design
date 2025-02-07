package ru.job4j.serialization.xml;

public class Main {
    final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
    final Company company = new Company("Cactus", true, new Contact("72-23-32"),
            new String[]{"construction", "property management"});
}
