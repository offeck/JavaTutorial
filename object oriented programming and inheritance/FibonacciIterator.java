import java.util.Iterator;
import java.util.NoSuchElementException;

public class FibonacciIterator implements Iterator<Integer> {

	// Fields
	private int nextValue;
	private int previousValue;
	private int maxValue;

	// Constructor
	public FibonacciIterator(int maxValue) {
		nextValue = 1;
		previousValue = 0;
		this.maxValue = maxValue;
	}

	// Methods
	public boolean hasNext() {
		return nextValue <= maxValue && nextValue > 0;
	}
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		int output = nextValue;
		nextValue = nextValue + previousValue;
		previousValue = output;
		return output;
	}
}