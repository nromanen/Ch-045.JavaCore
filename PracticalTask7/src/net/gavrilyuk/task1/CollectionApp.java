package net.gavrilyuk.task1;

import java.util.*;

/**
 *
 * Created by Igor Gavrilyuk on 16.10.2016.
 */

       /*Declare collection myCollection of 10 integers and fill it (from the console or random).
        1.Find and save in list newCollection all positions of element more than 5 in the collection. Print newCollection
        2.Remove from collection myCollection elements, which are greater then 20. Print result
        3.Insert elements 1, -3, -4 in positions 2, 8, 5. Print result in the format: “position – xxx, value of element – xxx”
        4.Sort and print collection*/
public class CollectionApp {

    private static final int INTEGERS_COUNT = 10;

    public static void main(String[] args) {

        TasksList myCollection = new TasksList();
        myCollection.fillList(INTEGERS_COUNT);
        System.out.println("myCollection=" + myCollection.toString());
        List<Integer> newCollection = myCollection.findIndexFromValue(5);
        System.out.println("newCollection=" + newCollection.toString());
        myCollection.removeByValue(20);
        System.out.println("after deleted myCollection=" + myCollection.toString());
        //add 1, -3, -4 in positions 2, 8, 5.
        myCollection.addValueToIndex(2, 1);
        myCollection.addValueToIndex(5, 4);
        myCollection.addValueToIndex(8, -3);
        System.out.println( myCollection.printList());
        Collections.sort(myCollection.getList());
        System.out.println("after sort tasksList=" + myCollection.toString());
        /*
        List<Integer> myCollection = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < INTEGERS_COUNT; i++) {
            myCollection.add(r.nextInt());
        }
        System.out.println("myCollection="+myCollection.toString());
        // create newCollection and find index >5
       List<Integer> newCollection = new ArrayList<>();
       for(ListIterator<Integer> it = myCollection.listIterator(); it.hasNext() ;)
        {
            int i = it.nextIndex();
            if (it.next()>5) newCollection.add(i);
        }
        System.out.println("newCollection="+newCollection.toString());

        for(ListIterator<Integer> it = myCollection.listIterator(); it.hasNext() ;)
        {
            int i = it.nextIndex();
            int value = it.next();
            if (value >20) {
                it.remove();
                //System.out.println("deleted i=" + i+ " value="+value);
            }

        }
        System.out.println("after deleted myCollection=" + myCollection.toString());
        //add 1, -3, -4 in positions 2, 8, 5.
        addValue(myCollection, 2, 1);
        addValue(myCollection, 5, 4);
        addValue(myCollection, 8, -3);


        System.out.println("after add myCollection=" + myCollection.toString());
        Collections.sort(myCollection);
        System.out.println("after sort myCollection=" + myCollection.toString());
    }

    private static void addValue(List<Integer> list,int index, int value) {
        try {
            if (list.size() < index) {
                throw new  IndexOutOfBoundsException("Index "+index+" is greater than the length of the list");
            } else list.add(index, value);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        */
    }

}
