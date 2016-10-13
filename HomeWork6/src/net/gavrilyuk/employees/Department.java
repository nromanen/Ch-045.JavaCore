package net.gavrilyuk.employees;

/**
 * Department enum
 * Created by Igor Gavryliuk on 12.10.2016.
 */
public enum Department {

    ADMIN("Administration"),
    MANAGE("Managers"),
    SALES("Salespeople"),
    SALARIED("Salaried");

    private String depName;

    Department( String depName) {
        this.depName = depName;
    }


    public String getDepName() {
        return depName;
    }

    public void setDepName( String depName) throws IllegalArgumentException{
            if(depName == null || depName.trim().isEmpty()){
                throw new IllegalArgumentException("Department name should not be empty!");
            }
           this.depName = depName;
    }

    @Override
    public String toString() {
        return ordinal()+" - "+ depName;
    }
}
