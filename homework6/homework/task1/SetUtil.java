package homework6.homework.task1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by roma on 19.10.2016.
 * Write parameteried methods union(Set set1, Set set2) and intersect(Set set1, Set set2),
 * realizing the operations of union and intersection of two sets. Test the operation of these techniques on two pre-filled sets.

 */
public class SetUtil<T> {
    public Set<T> union(Set<T> set1, Set<T> set2){
        Set<T> union = new HashSet<T>(set1);
        union.addAll(set1);
        union.addAll(set2);
        return union;
    }

    public Set<T> intersect(Set<T> set1, Set<T> set2){
        Set<T> intersect = new HashSet<T>(set1);
        intersect.retainAll(set2);
        return intersect;
    }
}
