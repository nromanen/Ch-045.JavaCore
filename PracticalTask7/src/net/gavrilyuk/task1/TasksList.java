package net.gavrilyuk.task1;

import java.util.*;

/**
 *
 * Created by Igor Gavrilyuk on 16.10.2016.
 */
public class TasksList  {

    private List<Integer> list = new LinkedList<>();

    public List<Integer> getList() {
        return list;
    }

    public void add(Integer element) {
         list.add(element);
    }

    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        if (index < size()) {
            list.add(index, element) ;
        } else throw new IndexOutOfBoundsException("Index "+index+" is greater than the length of the list");
    }

    public Integer get(int index) {
        return list.get(index);
    }

    public int size( ) {
        return list.size();
    }

   // return list of all positions of element more than value=5 in the collection
    public List<Integer> findIndexFromValue(int value) {
        List<Integer> result = new ArrayList<>();
        for(ListIterator<Integer> it = list.listIterator(); it.hasNext() ;)
        {
            int i = it.nextIndex();
            if (it.next() > value) result.add(i);
        }
        return result;
    }
    //remove item which are greater then value=20
    public void removeByValue(int value) {
        if (list != null) {
            for (ListIterator<Integer> it = list.listIterator(); it.hasNext(); ) {
                if (it.next() > value)   it.remove();
            }
        }
    }
    // insert the element(value) in position (index)
    public void insertValueInPosition(int index, Integer value ) {
            list.add(index, value);
    }

    //fill list random integer values
    public void fillList(int count) {
        Random r = new Random();
        if (list != null) {
            for (int i = 0; i < count; i++) {
                list.add(r.nextInt());
            }
        }
    }

    public String printList() {
        StringBuilder builder = new StringBuilder();
        if (!list.isEmpty()) {
            for (ListIterator<Integer> it = list.listIterator(); it.hasNext(); ) {
                builder.append("position - ").append(it.nextIndex()).append(", value of element - ").append(it.next()).append("\n");
            }

        } else builder.append("Empty list!").append("\n");
        return builder.toString();
    }

    @Override
    public String toString() {
        return "TasksList{" +
                "list=" + list +
                '}';
    }
}
