package collections.practice.task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static util.Print.println;

/**
 * Created by Admin on 18.10.16.
 */
public class Util {


    public static List<Integer> getMoreThanN(int n, List<Integer> list){
        List<Integer> result = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > n){
                result.add(i);
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
