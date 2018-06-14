import java.util.Comparator;

public class CompoundComparator<T> implements Comparator<T> {

	Comparator<T>[] comparators;

	public CompoundComparator(Comparator<T>... comparators){
		this.comparators = comparators;
	}

	@Override
	public int compare(T o1, T o2) {
		for (Comparator<T> c : comparators){
			int i = c.compare(o1, o2);
			if(i!=0){
				return i;
			}
		}
		return 0;
	}
}
