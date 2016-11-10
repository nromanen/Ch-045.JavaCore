package homework6.practical.task1;

import java.util.List;

/**
 * Created by roma on 16.10.2016.
 * Declare collection myCollection of 10 integers and fill it (from the console or random).
        * Find and save in list newCollection all positions of element more than 5 in the collection.
        Print newCollection
        * Remove from collection myCollection elements, which are greater then 20. Print result
        *Insert elements 1, -3, -4 in positions 2, 8, 5.
    Print result in the format: “position – xxx, value of element – xxx”
    Sort and print collection
 */
public class CollectionApp {
    public static void main(String [] args){

        UtilList myCollection = new UtilList();

        int count = 10;
        myCollection.fillRandomVal(count);
        System.out.println(myCollection);

        int findMore = 5;
        List<Integer> newCollection = myCollection.findSavePosMore(findMore);
        System.out.println("New list " + newCollection);

        int elementGreater = 20;
        myCollection.remoteFromCollection(elementGreater);
        System.out.println("\nRemove elements, which are greater then 20:");
        System.out.println(myCollection);


        myCollection.insertValueInPos(7,3);
        myCollection.insertValueInPos(3,5);
        myCollection.insertValueInPos(2,-9);
        System.out.println("My list after insert value :");
        System.out.print(myCollection.printList());
		
		//sort myCollection
        Collections.sort(myCollection.getMyList());
    }
}
