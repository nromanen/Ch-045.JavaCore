package homework6.practical.task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by roma on 19.10.2016.
 */
public class EmployeeMap {
    private Map<Integer,String> map;

    public EmployeeMap(){
        map = new HashMap<>();
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }

    public Map<Integer, String> getMap() {
        return map;
    }

    public void putEmpToMap(Employee employee){
       if(map != null){
           if (!map.containsKey(employee.getId())){
               map.put(employee.getId(),employee.getName());
           }
       }
    }

    public void printMap(){
        if(map != null){
            for(Map.Entry entry: map.entrySet()){
                System.out.println("key - "+entry.getKey()+" value - "+entry.getValue());
            }
        }
    }

    public String findNameById(int id){
        if (map.containsKey(id)){
            return map.get(id);
        } else {
            return "Can't find this ID!";
        }
    }

    public Set<Integer> findIdByName(String name){
        Set<Integer> set = new HashSet<>();
        if(map.containsValue(name)){
            for (Map.Entry entry: map.entrySet()){
                if (name.equals(entry.getValue())){
                    set.add((Integer)entry.getKey());
                }
            }
        } else {
            return null;
        }
        return set;
    }

    public void printSetIdName(Set<Integer> findIdSet,String name){
        if(findIdSet!=null){
            for (Integer set:findIdSet){
                System.out.println(set);
            }
        } else {
            System.out.println("Can't find user!");
        }
    }
}
