package net.gavtilyuk.task2;

import java.util.*;

/**
 *
 * Created by Igor Gavryliuk on 18.10.2016.
 */
public class PersonMap {

    Map<String,String> person = new HashMap<>();

    public Map<String, String> getPerson() {
        return person;
    }

    public void setPerson(Map<String, String> person) {
        this.person = person;
    }

    //return true if there are at less two persons with the same firstName - else false
    public boolean findDuplicateName() {
        if (person!=null && person.size()>0) {
            List<String> valuesList = new ArrayList<>(person.values());
            Set<String> valuesSet = new HashSet<>(person.values());
            //System.out.println(valuesList); System.out.println(valuesSet);
            if (valuesList.size() != valuesSet.size()) {
                return true;
            }
        }
        return false;
    }

    //return true if there are at less two persons with the same firstName - else false
    public Map<String, ArrayList<String>> getDuplicateNamesMap() {
        Map<String, ArrayList<String>> reverseMap = new HashMap<>();
        if (person != null && person.size() > 0) {
            for (Map.Entry<String, String> entry : person.entrySet()) {
                if (!reverseMap.containsKey(entry.getValue()))  reverseMap.put(entry.getValue(), new ArrayList<>());
                ArrayList<String> keys = reverseMap.get(entry.getValue());
                keys.add(entry.getKey());
                reverseMap.put(entry.getValue(), keys);
            }
        }
        return reverseMap;
    }

    // return count of removed persons or 0 if not found
    public int countRemoveWithFirsName(String name) {
        int personCount = 0;
        if (person != null) {
            Collection<String> list = person.values();
            for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
                if (it.next().equalsIgnoreCase(name) )  {
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
            Collection<String> list = person.values();
            for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
                if (it.next().equalsIgnoreCase(name) )  {
                    it.remove();
                    result = true;
                }
            }
        }
        return result;
    }

    //return  Map<String,String> without the persons with the  firstName = name
    public  Map<String,String> withoutDuplicateFirsName(String name) {
        Map<String,String> result = new HashMap<>(person);
        if (!result.isEmpty()) {
            Collection<String> list = result.values();
            for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
                if (it.next().equalsIgnoreCase(name) ) it.remove();


            }
        }
        return result;
    }
    //fill map sample values
    public void fillMap(int count) {
        final String[] FIRST_NAMES = new String[]{"Ihor","Jacob","Emily","Michael","David","Anna","Robert","Ihor","Thomas","Megan"};// duplicate name Ihor
       // final String[] FIRST_NAMES = new String[]{"Ihor","Jacob","Emily","Michael","David","Anna","Robert","Ivan","Thomas","Megan"};//no duplicate
        final String[] LAST_NAMES = new String[]{"Backer","Lamberts","Mansfield","Miller","Faber","Garrison","Watson","Taylor","Forster","Evans"};
        if (person == null) person=new HashMap<>();
        for (int i = 0; i < count; i++) {
            person.put(LAST_NAMES[i],FIRST_NAMES[i]);
        }
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (!person.isEmpty()) {
            for (Map.Entry<String, String> entry : person.entrySet()) {
                builder.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
        } else builder.append("Empty list!").append("\n");
        return builder.toString();
    }
}
