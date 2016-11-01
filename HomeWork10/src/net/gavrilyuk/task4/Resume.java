package net.gavrilyuk.task4;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by Igor Gavryliuk on 01.11.2016.
 */
public class Resume implements Serializable {

    private String name;
    private Date dateOfBirth;
    private String career;

    public Resume() {
    }

    public Resume(String name, Date dateOfBirth, String career) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.career = career;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", career='" + career + '\'' +
                '}';
    }
}
