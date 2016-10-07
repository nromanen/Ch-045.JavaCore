package net.gavrilyuk.person;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * Created by Igor Gavrilyuk on 05.10.2016.
 */
public class PersonLab {
    private static final String DB_FILENAME = "persons.json";
    private static PersonLab sPersonLab;

    private ArrayList<Person> mPersons;
    private PersonJSONSerializer mSerializer;


    private PersonLab() {
        mSerializer = new PersonJSONSerializer(DB_FILENAME);
        try {
            mPersons = mSerializer.loadPerson();
        } catch (Exception e) {
            mPersons = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public static PersonLab getInstance() {
        if (sPersonLab == null) {
            sPersonLab = new PersonLab();
        }
        return sPersonLab;
    }

    public Person getPerson(UUID id) {
        for (Person e : mPersons) {
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    public void addPerson(Person e) {
        mPersons.add(e);
        savePersons();
    }

    public void removePerson(int index) {
        mPersons.remove(index);
        savePersons();
    }

    public ArrayList<Person> getPersons() {
        return mPersons;
    }

    public boolean savePersons() {
        try {
            mSerializer.savePerson(mPersons);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
