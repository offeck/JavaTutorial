import java.util.Iterator;

public class ListOperations {

	public static <T> void printVertical(List<T> someList){
		for(int i = 0; i < someList.size(); i = i + 1){
			System.out.println(someList.get(i));
		}	
	}
	
	/*
	public static <T> void printVertical(List<T> someList){
		Iterator<T> itr = someList.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	*/

	public static <T> void reverse(List<T> someList){
		int size = someList.size();
		for(int i = 0; i < size / 2; i = i + 1){
			T element1 = someList.get(i);
			T element2 = someList.get(size - i - 1);
			someList.set(i, element2);
			someList.set(size - i - 1, element1);
		}	
	}


	public static <T> void listFilter(List<T> list, List<T> toRemove) {
		for(int i = 0; i < toRemove.size(); i = i + 1){
			T elementToRemove = toRemove.get(i);
			while (list.contains(elementToRemove)){
				list.remove(elementToRemove);
			}
		}
	}
	
}


