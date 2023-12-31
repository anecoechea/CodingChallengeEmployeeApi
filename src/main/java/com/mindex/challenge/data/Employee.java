package com.mindex.challenge.data;

import jdk.internal.jline.internal.Log;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    /**
     *
     * I think there is a bug when creating these because the only value that is store in the list
     * is the employee id. Ideally the objects should also include the name, department, etc. Not
     * sure exactly how to resolve this.
     */
    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }
}
