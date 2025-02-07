package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonInPogo {
    public static void main(String[] args) {

        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        final Person person = new Person(false, 30, new Contact("11-111"), new String[] {"Worker", "Married"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.getSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(person).toString());

        final Company company = new Company("Forest", false, new Contact("+7(2312)42-24-21"),
                new String[] {"Rest", "treatment"});
        System.out.println(new JSONObject(company).toString());

        JSONObject jsonContactCompany = new JSONObject("{\"phone\":\"+7(924)23-41-21\"}");

        List<String> listCompany = new ArrayList<>();
        listCompany.add("construction");
        listCompany.add("property management");
        JSONArray jsonActivitiesCompany = new JSONArray(listCompany);

        JSONObject jsonObjectCompany = new JSONObject();
        jsonObjectCompany.put("name", company.getName());
        jsonObjectCompany.put("open", company.getOpen());
        jsonObjectCompany.put("contact", jsonContactCompany);
        jsonObjectCompany.put("activity", jsonActivitiesCompany);

        System.out.println(jsonObjectCompany.toString());
    }
}
