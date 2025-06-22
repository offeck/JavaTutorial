public class SearchAndSort {

	public static void  main(String[] args){
		int[] a1 = {2,3,5,7}; 	int key1 = 5;
		int[] a2 = {2,3,5,7}; 	int key2 = 8;
		int[] a3 = {2,3,5,7}; 	int key3 = 2;
		int[] a4 = {}; 			int key4 = 3;
		int[] a5 = null; 		int key5 = 3;

		System.out.println("linear search tests:");
		System.out.println("test 1: "+linearSearch(a1,key1));
		System.out.println("test 2: "+linearSearch(a2,key2));
		System.out.println("test 3: "+linearSearch(a3,key3));
		System.out.println("test 4: "+linearSearch(a4,key4));
		//System.out.println(linearSearch(a5,key5));

		System.out.println("binary search tests:");
		System.out.println("test 1: "+binarySearch(a1,key1));
		System.out.println("test 2: "+binarySearch(a2,key2));
		System.out.println("test 3: "+binarySearch(a3,key3));
		System.out.println("test 4: "+binarySearch(a4,key4));
		//System.out.println(binarySearch(a5,key5));

		System.out.println("insertion sort tests:");
		int[] a6 = {2,7,3,5};
		printArray(a6);
		insertionSort(a6);
		printArray(a6);
		// add more tests!

		System.out.println("selection sort tests:");
		int[] a7 = {2,7,3,5};
		printArray(a7);
		selectionSort(a7);
		printArray(a7);
		// add more tests!

	}

	//----------------------------------------------------------
	// assumes array!=null
	public static int linearSearch(int[] array, int key){
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		int output = -1;   // default (not found) value
		for (int i = 0; i<array.length && output == -1; i=i+1){
			if (key == array[i])
				output = i;
		}
		return output;
	} 
	//----------------------------------------------------------
	// assumes array!=null
	public static int binarySearch(int[] array, int key){
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		int output = -1;   // default (not found) value
		boolean found = false;
		int low = 0;
		int high = array.length-1;
		while (low <= high && !found){
			int middle = (low+high)/2;
			if(array[middle] == key){
				output = middle;
				found = true;
			}
			else 
				if (key < array[middle])
					high = middle-1;
				else 
					low = middle+1;
		}	
		return output;
	}
	//----------------------------------------------------------
	// assumes array!=null
	public static void insertionSort(int[] array){
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		for (int i=1; i < array.length; i = i + 1){
			insert(array,i);
		}
	} 

	// assumes array!=null, 0<=i<array.length
	private static void insert(int[] array, int i){
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		if (i < 0 || i >= array.length) 
			throw new IllegalArgumentException("Index out of bounds");
		// insert the element at index i into its
		// correct position to the left
		int value = array[i];
		// shift the larger elements to the right
		while (i > 0 && array[i-1] > value){
			array[i] = array[i-1];
			i = i-1;
		}
		array[i] = value;
	} // insert
	//----------------------------------------------------------
	// assumes array!=null
	public static void selectionSort(int[] array){
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		for (int i = 0; i < array.length-1; i = i+1){
			int minInd = minIndex(array,i);
			swap(array, i, minInd);
		}
	} // selectionSort

	// Assumes array!=null & from<a.length
	public static int minIndex(int[] array, int from) {
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		if (from < 0 || from >= array.length) 
			throw new IllegalArgumentException("Index out of bounds");
		int minIndex = from;
		for(int i = from+1; i<array.length; i=i+1) 
			if (array[i] < array[minIndex]) 
				minIndex = i;  
		return minIndex;
	} // minIndex

	//swap element array[i] with array[j]
	// Assumes array!=null
	public static void swap(int[] array, int i, int j){
		if (array == null) 
			throw new IllegalArgumentException("Input array is null");
		if (i < 0 || j < 0 || i >= array.length || j >= array.length) 
			throw new IllegalArgumentException("Index out of bounds");
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	} // swap

	//----------------------------------------------------------
	public static void printArray(int[] array){
		if (array == null)
			System.out.print(array);
		else{
			System.out.print("{ ");
			for(int element: array)
				System.out.print(element+" ");
			System.out.println("}");
		}
	}
}
