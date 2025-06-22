public class DynamicIntegerArray extends DynamicArray<Integer> {
	
    public DynamicIntegerArray() {
    	super();
    }
    
    public int sum() {
        int output = 0;
        for (int i = 0; i < size(); i = i + 1) {
            output = output + get(i);
        }
        return output;
    }
}
