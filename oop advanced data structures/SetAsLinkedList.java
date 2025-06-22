import java.util.Iterator;

public class SetAsLinkedList<T> implements Set<T> {

	private List<T> elements ;

	public SetAsLinkedList() {
		elements = new LinkedList<>();
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public int size() {
		return elements.size();
	}

	public boolean contains(T element) {
		return elements.contains(element);
	}

	public boolean add(T element) {
		if(element == null)
			throw new NullPointerException();
		if (! contains(element)){
			elements.add(element);
			return true;
		}
		return false;
	}

	public boolean remove(T element) {
		return elements.remove(element);
	}    
	
	public Iterator<T> iterator() {
		return elements.iterator();
	}

	public String toString() {
		String output = "{";

		Iterator<T> it= iterator ();
		while (it.hasNext()) {
			output = output+it.next()+", ";
		}

		if (!isEmpty())
			output = output.substring(0, output.length()-2);
		output = output+"}";
		return output;
	}
	
	public boolean equals(Object other) {
		boolean isEqual = true;
		if (!(other instanceof Set<?>))
			isEqual = false;
		else {
			Set<T> otherSet = (Set<T>) other;
			if (size() != otherSet.size())
				isEqual = false;
			else {
				Iterator<T> iter = iterator();
				while (iter.hasNext() & isEqual){
					T next = iter.next();
					isEqual = otherSet.contains(next);
				}
			}
		}
		return isEqual;	
	}

}
