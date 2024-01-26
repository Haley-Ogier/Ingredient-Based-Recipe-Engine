
import java.util.HashSet;
import java.util.Set;
public class ingredientsSearch {
	public static <E> Set<E> union(Set<E> s, Set<E> t) {
		Set<E> toReturn = new HashSet<E>();
		toReturn.addAll(s);
		toReturn.addAll(t);
		return toReturn;
	}

	public static <E> Set<E> intersection(Set<E> s, Set<E> t) {
		Set<E> intersectionSet = new HashSet<E>(s);
		intersectionSet.retainAll(t);
		return intersectionSet;
	}

	public static <E> Set<E> setDifference(Set<E> s, Set<E> t) {
		Set<E> difference = new HashSet<E>();
		difference = union(s,t);
		difference.removeAll(t);
		return difference;
	}
	
	public static <E> double jaccardIndex(Set<E> s, Set<E> t) {
		if (s.isEmpty() && t.isEmpty()){
			return 1;
		}else{
			int sizeOfInter = intersection(s, t).size();
			int sizeOfUnion = union(s,t).size();
			return (sizeOfInter*1.0)/sizeOfUnion;
		}
	}
}
