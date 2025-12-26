package ru.job4j.ood.ocp;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.WrapperEmployee;
import ru.job4j.ood.srp.model.WrapperEmployees;
import ru.job4j.ood.srp.report.Report;
import ru.job4j.ood.srp.store.Store;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class ReportToXML implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;

    public ReportToXML(Store store, DateTimeParser<Calendar> dateTimeParser) throws JAXBException {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String rsl = "";
        List<WrapperEmployee> wrapperEmployeeList = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            wrapperEmployeeList.add(new WrapperEmployee(employee.getName(),
                    dateTimeParser.parse(employee.getFired()),
                    dateTimeParser.parse(employee.getHired()),
                    employee.getSalary()));
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(WrapperEmployees.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(new WrapperEmployees(wrapperEmployeeList), writer);
                rsl = writer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return rsl;
    }
}
