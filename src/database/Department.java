package database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Department {

    private String title;
    private Employee lead;
    private String description;
    private String disposition;
    private Set<Employee> employees = new HashSet<>();

    public Department(String title, Employee lead, String disposition) {
        this.title = title;
        this.lead = lead;
        this.disposition = disposition;
    }

    public Department(String title, Employee lead, String description, String disposition) {
        this(title, lead, disposition);
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getLead() {
        return lead;
    }

    public void setLead(Employee lead) {
        this.lead = lead;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(List<Employee> employees) {

        for (Employee employee : employees) {
            this.employees.add(employee);
        }
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void removeEmployee(Employee employee){
        if (this.employees.contains(employee)){
            this.employees.remove(employee);
        }
    }

    public void removeEmployees(List<Employee> employees){
        for (Employee employee : employees) {
            if (this.employees.contains(employee)){
                this.employees.remove(employee);
            }
        }
    }

    public List<Employee> getEmployeeByName(String firstName, String lastName){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if(employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeeByAge(int start, int end){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if(employee.getAge() >= start && employee.getAge() <= end){
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeeByRate(int start, int end){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if(employee.getRate() >= start && employee.getRate() <= end){
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeeByAge(Position position){
        List<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if(employee.getPosition().equals(position)){
                result.add(employee);
            }
        }
        return result;
    }



}
