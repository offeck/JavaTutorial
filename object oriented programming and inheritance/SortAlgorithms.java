import java.util.Comparator;

public class SortAlgorithms {
	public static <T extends Comparable<T>> void insertionSort(T[] array) {
		for (int i = 1; i < array.length; i = i + 1) {
			insert(array, i);
		}
	}

	private static <T extends Comparable<T>> void insert(T[] array, int i){
		T value = array[i];
		while (i > 0 && array[i - 1].compareTo(value) > 0) {
			array[i] = array[i - 1];
			i = i - 1;
		}
		array[i] = value;
	}

	public static <T> void insertionSort(T[] array, Comparator<T> comp){
		for (int i = 1; i < array.length; i = i + 1) {
			insert(array, i, comp);
		}
	}

	private static <T> void insert(T[] array, int i, Comparator<T> comp){
		T value = array[i];
		while (i > 0 && comp.compare(array[i-1],value)> 0){
			array[i] = array[i - 1];
			i = i - 1;
		}
		array[i] = value;
	}

}

