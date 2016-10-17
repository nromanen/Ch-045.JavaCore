package homework6.practical;

import java.util.*;

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
public class Task1 {

    public static List<Integer> myCollection;
    public static List<Integer> newCollection;
    public static Integer greater = 20;

    public static void main(String[] args){

        //Declare collection myCollection of 10 integers and fill it (from the console or random)
        Random random = new Random();

        //input
        myCollection = new LinkedList<>();
        for (int i=0; i<10; i++){
            myCollection.add(random.nextInt(30));
        }

        //output
        System.out.println("MyCollection:");
        for(Integer list: myCollection){
            System.out.print(list+"  ");
        }

        //Find and save in list newCollection all positions of element more than 5 in the collection.Print newCollection
        System.out.println("\nNewCollection(after selecting values greater than 5 ):");

        newCollection = new ArrayList<>();

        getNewCollection(myCollection);
        for (Integer newList: newCollection){
            System.out.print(newList + " ");
        }

        //Remove from collection myCollection elements, which are greater then 20. Print result
        System.out.println("\nNewCollection(remove values > 20):");

        if (remoteGreaterInt(greater)){
            for (Integer newList: newCollection){
                System.out.print(newList + " ");
            }
        }

        //Insert elements 1, -3, -4 in positions 2, 8, 5
        int[] arrValues = {1,-3,-4};
        int[] arrPosition = {2,8,5};

        System.out.println("\nList after insert values:");
        insertValuesInPos(arrPosition, arrValues);

        //sorted collection newCollection:
        System.out.println("\nSorted collection newCollection:");
        Collections.sort(newCollection);

        for (Integer newList: newCollection){
            System.out.print(newList + " ");
        }
    }

    public static void getNewCollection(List<Integer> myCollection){
        for(Integer list:myCollection ){
            if (list > 5){
                newCollection.add(list);
            }
        }
    }

    //
    public static boolean remoteGreaterInt(int greater){

        boolean isRemote = false;
        for(Iterator<Integer> iterator = newCollection.iterator(); iterator.hasNext();){
            int search = iterator.next();
            if(greater <= (search)){
                iterator.remove();
                isRemote = true;
            }
        }
        return isRemote;
    }

    //
    public static void insertValuesInPos(int[] arrPosition, int[] arrValues){

        for(int i=0; i<arrValues.length; i++){
            if (arrPosition[i] > newCollection.size()) {
                do {
                    newCollection.add(0);
                } while (arrPosition[i] > newCollection.size());
            }

            newCollection.add(arrPosition[i], arrValues[i]);

            //“position – xxx, value of element – xxx
            System.out.println("position - "+arrPosition[i]+", value of element - "+arrValues[i]);
        }
    }

}
