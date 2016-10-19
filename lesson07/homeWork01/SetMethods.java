package lesson07.homeWork01;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class SetMethods {

	public SetMethods() {

	}

	@SafeVarargs
	public static <T> Set<T> union(Collection<T>... sets) {
		Set<T> union = new TreeSet<T>();
		for (Collection<T> list : sets) {
			union.addAll(list);
		}
		return union;
	}

	public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
		Set<T> intersection = new TreeSet<T>(set1);
		intersection.retainAll(set2);
		return intersection;
	}

	
	
}
