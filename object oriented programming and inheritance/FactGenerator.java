import java.util.Iterator;
import java.util.NoSuchElementException;

public class FactGenerator implements Iterator<Integer> {
	
	// fields
	private int n;
	private int next;

	// Constructor
	public FactGenerator(int index) {
		this.n = 0;
		this.next = 1;
		for(int i = 0; i < index; i = i + 1) {
			this.next();
		}
	}

	// Methods
	public boolean hasNext() {
		return true;
	}
	
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int result = this.next;	
		this.n = this.n + 1;
		this.next = this.next * this.n;
		return result;

	}
}
