package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportHRTest {

    @Test
    public void whenAddEmployeeThenReturnOnlyHisNameAndSalary() {
        Calendar now = Calendar.getInstance();
        Store store = new MemoryStore();
        Employee worker = new Employee("Ivan", now, now, 100);
        Report reportHR = new ReportHR(store);
        store.add(worker);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        String result = reportHR.generate(employee1 -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenEmployeeOneSalaryLessThanEmployeeTwoSalaryReturnTwoOne() {
        Calendar now = Calendar.getInstance();
        Store store = new MemoryStore();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 150);
        store.add(worker1);
        store.add(worker2);
        Report reportHR = new ReportHR(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator());
        String result = reportHR.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenEmployeeTwoSalaryLessThanEmployeeOneSalaryReturnOneTwo() {
        Calendar now = Calendar.getInstance();
        Store store = new MemoryStore();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 15);
        store.add(worker1);
        store.add(worker2);
        Report reportHR = new ReportHR(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator());
        String result = reportHR.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }

    @Test
    public void whenEmployeeOneSalaryEqualsEmployeeTwoSalaryReturnOneTwo() {
        Calendar now = Calendar.getInstance();
        Store store = new MemoryStore();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Alex", now, now, 100);
        store.add(worker1);
        store.add(worker2);
        Report reportHR = new ReportHR(store);
        StringBuilder expected = new StringBuilder();
        expected.append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(" ")
                .append(worker1.getSalary())
                .append(System.lineSeparator())
                .append(worker2.getName()).append(" ")
                .append(worker2.getSalary())
                .append(System.lineSeparator());
        String result = reportHR.generate(employee -> true);
        assertThat(result).isEqualTo(expected.toString());
    }
}