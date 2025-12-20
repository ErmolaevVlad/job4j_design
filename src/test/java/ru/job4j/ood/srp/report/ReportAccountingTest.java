package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportAccountingTest {

    @Test
    public void whenConvertSalaryFromRUBtoRUBThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.RUB, Currency.RUB);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromRUBtoUSDThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.RUB, Currency.USD);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromRUBtoEURThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.RUB, Currency.EUR);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), Currency.EUR))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromUSDtoRUBThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.USD, Currency.RUB);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.USD, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromUSDtoUSDThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.USD, Currency.USD);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.USD, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromUSDtoEURThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.USD, Currency.EUR);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.USD, worker.getSalary(), Currency.EUR))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromEURtoRUBThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.EUR, Currency.RUB);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.EUR, worker.getSalary(), Currency.RUB))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromEURtoUSDThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.EUR, Currency.USD);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.EUR, worker.getSalary(), Currency.USD))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenConvertSalaryFromEURtoEURThenGetCurrentSalary() {
        Calendar now = Calendar.getInstance();
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportAccounting = new ReportAccounting(store, converter, parser, Currency.EUR, Currency.EUR);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(parser.parse(worker.getHired())).append(" ")
                .append(parser.parse(worker.getFired())).append(" ")
                .append(converter.convert(Currency.EUR, worker.getSalary(), Currency.EUR))
                .append(System.lineSeparator());
        String result = reportAccounting.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }
}