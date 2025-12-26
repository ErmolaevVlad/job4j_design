package ru.job4j.ood.ocp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.WrapperEmployee;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportToJson implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;


    public ReportToJson(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<WrapperEmployee> wrapperEmployeeList = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            wrapperEmployeeList.add(new WrapperEmployee(employee.getName(),
                    dateTimeParser.parse(employee.getFired()),
                    dateTimeParser.parse(employee.getHired()),
                    employee.getSalary()));
        }
        return gson.toJson(wrapperEmployeeList).toString();
    }
}
