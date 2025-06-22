public class Record<V>  {
	// Fields
	private String key;
	private V value;

	// Constructor
	public Record(String key, V value) {
		this.key = key;
		this.value = value;
	}

	// Methods
	public int compareTo(Record<V> other) {
		return key.compareTo(other.key);
	}
	
	public String getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public String toString() {
		return "["+key+", "+value+"]";				
	}

	public boolean equals(Object other) {
		boolean equals = false;
		if (other instanceof Record) {
			equals = key.equals(((Record<?>) other).key)
					&& (value.equals(((Record<?>) other).value));
		}
		return equals;
	}
}