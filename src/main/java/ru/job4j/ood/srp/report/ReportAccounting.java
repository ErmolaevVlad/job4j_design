package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportAccounting {

    private final Store store;
    private final CurrencyConverter converter;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportAccounting(Store store, CurrencyConverter converter, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.converter = converter;
        this.dateTimeParser = dateTimeParser;
    }

    private double convert(Currency source, double sourceValue, Currency target) {
        return converter.convert(source, sourceValue, target);
    }

    public String generate(Predicate<Employee> filter, Currency source, Currency target) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
            .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dateTimeParser.parse(employee.getHired())).append(" ")
                    .append(dateTimeParser.parse(employee.getFired())).append(" ")
                    .append(convert(source, employee.getSalary(), target))
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
