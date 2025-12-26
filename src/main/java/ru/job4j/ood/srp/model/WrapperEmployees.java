package ru.job4j.ood.srp.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class WrapperEmployees {

    @XmlElement(name = "employee")
    private List<WrapperEmployee> employeesList;

    public WrapperEmployees(List<WrapperEmployee> employeesList) {
        this.employeesList = employeesList;
    }

    public WrapperEmployees() {

    }

    public List<WrapperEmployee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<WrapperEmployee> employeesList) {
        this.employeesList = employeesList;
    }
}
