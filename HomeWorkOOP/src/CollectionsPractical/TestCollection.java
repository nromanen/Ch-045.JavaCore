package CollectionsPractical;

import java.util.*;

/**
 * Created by evil on 20.10.16.
 */
public class TestCollection {
    private static List<Integer> myCollection = new ArrayList<Integer>();
    private static List<Integer> newCollection = new LinkedList<Integer>();
    //add 10 number to collection
    public static void addToMyCollection(){
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            myCollection.add(random.nextInt(101) - 50);
        }
    }
    // add number > 5 to new collection
    public static void addToNewCollection(){
        Iterator iterator = myCollection.iterator();
        for (int i = 0; i < myCollection.size(); i++){
            if (myCollection.get(i)>5) newCollection.add(myCollection.get(i));
        }
    }

     public static void printCollection(List list){
         for (int i = 0; i < list.size(); i++){
             System.out.println("Position: " + list.indexOf(list.get(i))
                                + " value: " + list.get(i));
         }
     }
     // remove number more then 20
     public static void removeFromMyCollection(){
         for (int i = 0; i < myCollection.size(); i++){
            if (myCollection.get(i) > 20) myCollection.remove(i);
         }
         System.out.println("After removing more then 20");
         printCollection(myCollection);
     }

     public static void insertingToPosition(){
         myCollection.add(2, 1);
         myCollection.add(8, -3);
         myCollection.add(5, -4);
         System.out.println("After inserting");
         printCollection(myCollection);
     }

    public static void main(String[] args) {
        TestCollection.addToMyCollection();
        TestCollection.addToNewCollection();
        System.out.println("My collection");
        TestCollection.printCollection(myCollection);
        System.out.println("New collection");
        TestCollection.printCollection(newCollection);
        TestCollection.removeFromMyCollection();
        TestCollection.insertingToPosition();
    }
}
