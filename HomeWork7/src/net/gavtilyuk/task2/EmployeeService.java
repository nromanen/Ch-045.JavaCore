package net.gavtilyuk.task2;

import java.util.*;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class EmployeeService {

    Map<Integer,Employee> person = new HashMap<>();

    public Map<Integer, Employee> getPerson() {
        return person;
    }

    public void setPerson(Map<Integer, Employee> person) {
        this.person = person;
    }

    //return true if there are at less two persons with the same firstName - else false
    public boolean isDuplicateFirstName() {
        if (person != null && person.size() > 0) {
            List<String> values = new ArrayList<>();

            Set<String> uniqueValues = new HashSet<>();
            for (Employee employee : person.values()) {
                values.add(employee.getFirstName());
                uniqueValues.add(employee.getFirstName());
            }
            if (values.size() != uniqueValues.size()) {
                return true;
            }
        }
        return false;
    }

    //return map if there are at less  persons with the same  FistName
    //  else return empty map
    public Map<Integer,Employee> findDuplicateFirstNames() {
        Map<Integer,Employee> result = new HashMap<>();
        List<String> values = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<>();
        for (Employee employee : person.values()) {
            uniqueValues.add(employee.getFirstName());
            values.add(employee.getFirstName());
        }
        for (String temp : uniqueValues) {
            int freq = Collections.frequency(values, temp);
            if (freq > 1) {
                //System.out.println(temp + ": " + freq);
                for (Map.Entry<Integer, Employee> entry : person.entrySet()) {
                    if (Objects.equals(temp, entry.getValue().getFirstName())) {
                        result.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        return result;
    }
    //return map if there are at less  persons with the same firstName and LastName
    //  else return empty map
    public Map<Integer,Employee> findDuplicateNames() {
        Map<Integer,Employee> result = new HashMap<>();
        Set<Employee> uniqueValues = new HashSet<>(person.values());
        for (Employee temp : uniqueValues) {
            int freq = Collections.frequency(person.values(), temp);
            if (freq > 1) {
                //System.out.println(temp + ": " + freq);
                for (Map.Entry<Integer, Employee> entry : person.entrySet()) {
                    if (Objects.equals(temp, entry.getValue())) {
                        result.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
     return result;
    }

    //return map if there are at less  persons with the same  LastName
    //  else return empty map
    public Map<Integer,Employee> findDuplicateLastNames() {
        Map<Integer,Employee> result = new HashMap<>();
        List<String> values = new ArrayList<>();
        Set<String> uniqueValues = new HashSet<>();
        for (Employee employee : person.values()) {
            uniqueValues.add(employee.getLastName());
            values.add(employee.getLastName());
        }
        for (String temp : uniqueValues) {
            int freq = Collections.frequency(values, temp);
            if (freq > 1) {
                //System.out.println(temp + ": " + freq);
                for (Map.Entry<Integer, Employee> entry : person.entrySet()) {
                    if (Objects.equals(temp, entry.getValue().getLastName())) {
                        result.put(entry.getKey(),entry.getValue());
                    }
                }
            }
        }
        return result;
    }

    // return count of removed persons or 0 if not found
    public int countRemoveWithFirsName(String name) {
        int personCount = 0;
        if (person != null) {
            Collection<Employee> list = person.values();
            for (Iterator<Employee> it = list.iterator(); it.hasNext(); ) {
                if (it.next().getFirstName().equalsIgnoreCase(name) )  {
                    it.remove();
                    personCount++;
                }
            }
        }
        return personCount;
    }
    // return true of removed persons or false if not found
    public boolean removeWithFirsName(String name) {
        boolean result = false;
        if (person != null) {
            Collection<Employee> list = person.values();
            for (Iterator<Employee> it = list.iterator(); it.hasNext(); ) {
                if (it.next().getFirstName().equalsIgnoreCase(name) )  {
                    it.remove();
                    result = true;
                }
            }
        }
        return result;
    }

    //return  Map<Integer,Employee> without the persons with the  firstName = name
    public  Map<Integer,Employee> withoutDuplicatesByFirsName(String name) {
        Map<Integer,Employee> result = new HashMap<>(person);
        if (!result.isEmpty()) {
            Collection<Employee> list = result.values();
            for (Iterator<Employee> it = list.iterator(); it.hasNext(); ) {
                if (it.next().getFirstName().equalsIgnoreCase(name) ) it.remove();


            }
        }
        return result;
    }

    //fill map sample values for testing
    public void fillMap(int count) throws IllegalArgumentException {
        // duplicate firstName Ihor
        final String[] FIRST_NAMES = new String[]{"Megan","Jacob","Ihor","Michael","David","Anna","Robert","Ihor","Thomas","Megan"};
        //no duplicate firstName
       // final String[] FIRST_NAMES = new String[]{"Ihor","Jacob","Emily","Michael","David","Anna","Robert","Ivan","Thomas","Megan"};
        //no duplicate lastName
      //  final String[] LAST_NAMES = new String[]{"Backer","Lamberts","Mansfield","Miller","Faber","Garrison","Watson","Taylor","Forster","Evans"};
        //duplicate lastName Taylor
        final String[] LAST_NAMES = new String[]{"Backer","Lamberts","Taylor","Miller","Faber","Taylor","Watson","Taylor","Forster","Evans"};
        if (person == null) person = new HashMap<>();
        for (int i = 0; i < count; i++) {
            person.put(i, new Employee(FIRST_NAMES[i], LAST_NAMES[i]));
        }
    }

    public String printMap(Map<Integer,Employee> map) {
        StringBuilder builder = new StringBuilder();
        if (!map.isEmpty()) {
            for (Map.Entry<Integer, Employee> entry : map.entrySet()) {
                builder.append("key=").append(entry.getKey()).append(" ").append(entry.getValue().toString()).append("\n");
            }
        } else builder.append("Empty list!").append("\n");
        return builder.toString();
    }

    @Override
    public String toString() {
       return printMap(person);
    }
}
