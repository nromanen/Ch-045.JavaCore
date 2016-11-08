package com.ariezz.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int depId;
    private String title;
    //private Employee leader;
    private String disposition;
    private String description;
    //private List<Employee> employees;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Employee getLeader() {
//        return leader;
//    }


//    public void setLeader(Employee leader) {
//        this.leader = leader;
//    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void addEmployee(Employee employee) {
//        if (this.employees == null){
//            this.employees = new ArrayList<>();
//        }
//        this.employees.add(employee);
//    }

    @Override
    public String toString() {
        return title;
    }
}
