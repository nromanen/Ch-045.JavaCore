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

    public void add(int index, Integer element) {
        if (index < size()) list.add(index, element);
    }

    public Integer get(int index) {
        return list.get(index);
    }

    public int size( ) {
        return list.size( );
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
    // add value from index
    // if index out of list size throw exception
    public void addValueToIndex(int index, Integer value ) {
        try {
            if (list.size() < index) {
                throw new  IndexOutOfBoundsException("Index "+index+" is greater than the length of the list");
            }
            list.add(index, value);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
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

    @Override
    public String toString() {
        return "TasksList{" +
                "list=" + list +
                '}';
    }
}
