package homework6.homework.person;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by roma on 19.10.2016.
 */
public class PersonMap {
    private Map<String,String> personMap;

    public PersonMap(){
        personMap = new HashMap<>();
    }

    public void setPersonMap(Map<String, String> personMap) {
        this.personMap = personMap;
    }

    public Map<String, String> getPersonMap() {
        return personMap;
    }

    public void putPersonToMap(Person person){
        if(personMap != null){
            if (personMap.containsKey(person.getFirstName())){
                System.out.println("Name - "+person.getFirstName()+" already in use! " );
            } else {personMap.put(person.getFirstName(),person.getLastName());}
        }
    }
    public void removePerson(String name){
        if (personMap.containsKey(name)){
            personMap.remove(name);
        }
    }
    public void printPersonMap(){
        for (Map.Entry entry: personMap.entrySet()){
            System.out.println(entry);
        }
    }
}
