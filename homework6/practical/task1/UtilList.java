package homework6.practical.task1;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by roma on 18.10.2016.
 */
public class UtilList {

    public static final int RANGE = 30; //For Random [0-30]

    private List<Integer> myList = new LinkedList<>();

    public List<Integer> getMyList() {
        return myList;
    }

    public void fillRandomVal(int count){
        Random random = new Random();
        for (int i=0; i<count; i++){
            myList.add(random.nextInt(RANGE));
        }
    }
    public List<Integer> findSavePosMore(int value){
        List<Integer> newList = new LinkedList<>();
        for(ListIterator<Integer> iterator = myList.listIterator(); iterator.hasNext();){
            int i  = iterator.nextIndex();
            if(iterator.next()>value){
                newList.add(i);
            }
        }
        return newList;
    }
    public void remoteFromCollection(int value){
        for (ListIterator<Integer> iterator = myList.listIterator(); iterator.hasNext();){
            if (iterator.next()> value){
                iterator.remove();
            }
        }
    }
    public void insertValueInPos(int position, int value){
        if (position <= myList.size()){
            myList.add(position, value);
        }
    }
    public String printList(){
        StringBuilder builder = new StringBuilder();
        for(ListIterator<Integer> iterator = myList.listIterator(); iterator.hasNext();){
            builder.append("position - ").append(iterator.nextIndex())
            .append("  value - ").append(iterator.next()).append("\n");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "My list " + myList +"\n";
    }
}
