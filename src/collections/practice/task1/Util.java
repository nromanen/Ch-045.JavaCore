package collections.practice.task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static util.Print.println;

/**
 * Created by Admin on 18.10.16.
 */
public class Util {


    public static List<Integer> getMoreThan5(List<Integer> list){
        List<Integer> result = new LinkedList<>();

        for (Integer item : list) {
            if(item > 5){
                result.add(item);
            }
        }
        return result;
    }

    public static boolean removeGreatThanN(int n, List<Integer> list){

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){

            if ((Integer)iterator.next() > n)
                iterator.remove();
        }

        return true;

    }

    public static boolean insertElement(int position, int value, List<Integer> list){
        if(position < 0 || position >= list.size()){
            return false;
        } else {
            list.add(position, value);
            println("insert: ", value, " to position: ", position);
            return true;
        }
    }
}
