package students.model;

import students.logic.SQLContract.StudentsEntry;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Person abstract class
 * Created by Igor Gavryliuk on 28.10.2016.
 */
public abstract class Person implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private int groupId;

    public Person() {
    }

    public Person(ResultSet rs) throws SQLException {
        setId(rs.getInt(StudentsEntry.ID));
        setFirstName(rs.getString(StudentsEntry.COL_FIRST_NAME));
        setLastName(rs.getString(StudentsEntry.COL_LAST_NAME));
        setGroupId(rs.getInt(StudentsEntry.COL_GROUP_ID));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return firstName+" "+lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        if (getId() != person.getId()) return false;
        if (getGroupId() != person.getGroupId()) return false;
        if (!getFirstName().equals(person.getFirstName())) return false;
        return getLastName().equals(person.getLastName());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getGroupId();
        return result;
    }

    @Override
    public String toString() {
        return "id=" + id +", firstName='" + firstName + '\'' +", lastName='" + lastName + '\''+" groupId="+groupId;
    }
}
