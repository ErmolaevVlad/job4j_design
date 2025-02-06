package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact("11-111"),
                new String[] {"Worker", "Married"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);

        final Company company = new Company("Cactus", true, new Contact("72-23-32"),
                new String[]{"construction", "property management"});

        final Gson gsonCompany = new GsonBuilder().create();
        System.out.println(gsonCompany.toJson(company));
        final String companyJson =
                "{"
                        + "\"name\":Forest,"
                        + "\"open\":false,"
                        + "\"contact\":"
                        + "{"
                        + "\"phone\":\"+7(2312)42-24-21\""
                        + "},"
                        + "\"fieldOfActivity\":"
                        + "[\"Rest\",\"treatment\"]"
                        + "}";
        final Company companyMod = gson.fromJson(companyJson, Company.class);
        System.out.println(companyMod);
    }
}