package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportProgrammersTest {

    @Test
    public void whenListOfEmployeesHasOneEmployeeThenFileCSVHasOneEmployee() {
        String path = "data/ProgrammerReport.csv";
        Calendar now = Calendar.getInstance();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportProgrammers reportProgrammers = new ReportProgrammers(store, parser, path);
        StringBuilder rsl = new StringBuilder();
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        String generatedReport = reportProgrammers.generate(employee -> true);
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                rsl.append(reader.readLine());
                rsl.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(generatedReport)
                .isEqualTo(expected.toString())
                .isEqualTo(rsl.toString());
    }

    @Test
    public void whenListOfEmployeesHasTwoEmployeesThenFileCSVHasTwoEmployees() {
        String path = "data/ProgrammerReport.csv";
        Calendar now = Calendar.getInstance();
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alex", now, now, 150);
        store.add(worker);
        store.add(worker1);
        ReportProgrammers reportProgrammers = new ReportProgrammers(store, parser, path);
        StringBuilder rsl = new StringBuilder();
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(parser.parse(worker.getHired())).append(";")
                .append(parser.parse(worker.getFired())).append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(parser.parse(worker1.getHired())).append(";")
                .append(parser.parse(worker1.getFired())).append(";")
                .append(worker1.getSalary())
                .append(System.lineSeparator());
        String generatedReport = reportProgrammers.generate(employee -> true);
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                rsl.append(reader.readLine());
                rsl.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(generatedReport)
                .isEqualTo(expected.toString())
                .isEqualTo(rsl.toString());
    }
}