package teacher.model;

import org.joda.time.DateTime;

import java.sql.Date;

/**
 * Created by roma on 24.10.2016.
 * Create class Teacher with fields: lastName, firstName, position, dateOfBirthday.
 Create class Department with fields: title, teachers.
 Consider appropriate methods.
 */

public class Teacher {

    public static final int RATE = 100;

    private int id;
    private String firstName;
    private String lastName;
    private Positions position;
    
    private DateTime dateOfBirthday;
    private int departmentId;

    //private String rank;
    private Category qualifyingCategory;
    private int load;

    public Teacher(){}

    public Teacher(String firstName, String lastName, Positions position, Date dateOfBirthday, int departmentId, Category qualifyingCategory, int load) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.dateOfBirthday = new DateTime(dateOfBirthday);
        this.departmentId = departmentId;
        this.qualifyingCategory = qualifyingCategory;
        this.load = load;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getRate() {
        return RATE;
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

    public Positions  getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public DateTime getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = new DateTime(dateOfBirthday);
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public Category getQualifyingCategory() {
        return qualifyingCategory;
    }

    public void setQualifyingCategory(Category qualifyingCategory) {
        this.qualifyingCategory = qualifyingCategory;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    //return ((this.salary()) * (100 + bonuses) )/100;
    public int calculateSalary(){
        int surcharge = qualifyingCategory.getSurcharge();
        return ((load * RATE)*(100 + surcharge))/100;
    }

    @Override
    public String toString() {
        return String.format("%-2d %-8s %-10s %-10s %s %8s %-17s %-3d",
                id,firstName,lastName,position,departmentId,dateOfBirthday,qualifyingCategory,load);
    }

/*
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", dateOfBirthday=" + dateOfBirthday +
                ", departmentId=" + departmentId +
                ", qualifyingCategory=" + qualifyingCategory +
                ", load=" + load +
                '}';
    }
    */
}
