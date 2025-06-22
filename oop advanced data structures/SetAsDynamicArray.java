import java.util.Iterator;

public class SetAsDynamicArray<T> implements Set<T> {
	private List<T> elements;
	
	public SetAsDynamicArray() {
		elements = new DynamicArray<>();
	}
	
	public Iterator<T> iterator() {
		return elements.iterator();
	}

	public boolean add(T element) {
		if(element == null)
			throw new IllegalArgumentException("input argumen is null");
		if (! contains(element)){
			elements.add(element);
			return true;
		}
		return false;
	}

	public int size() {
		return elements.size();
	}

	public boolean contains(T element) {
		return elements.contains(element);
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}
	
	public boolean remove(T element) {
		return elements.remove(element);
	}
	
	public String toString() {
		String output = "Set: {";
		Iterator<T> iter = elements.iterator();
		while(iter.hasNext()){
			output = output + iter.next();
			if(iter.hasNext())
				output = output + ", ";
		}
		output = output+"}";
		return output;
	}
	
	public boolean equals(Object other) {
		boolean isEqual = true;
		if (!(other instanceof Set<?>))
			isEqual = false;
		else {
			Set<?> otherSet = (Set<?>)other;
			if (size() != otherSet.size())
				isEqual = false;
			else {
				Iterator<T> iter = iterator();
				while (iter.hasNext() & isEqual){
					boolean found = false;
					T next = iter.next();
					Iterator<?> otherIter = ((Set<?>)other).iterator();
					while(otherIter.hasNext() & !found){
						if(next.equals(otherIter.next()))
							found = true;
					}
					if(!found)
						isEqual = false;
				}
			}
		}
		return isEqual;	
	}
}
