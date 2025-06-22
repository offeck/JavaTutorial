
public class PS08_Test {

	public static void main(String[] args) {

		LinkedList<Integer> myList = new LinkedList<Integer>();
		System.out.println(myList.size());
		myList.add(4);
		myList.add(8);
		myList.add(6);
		myList.add(5);
		myList.add(7);
		myList.add(2);
		
		System.out.println(myList.size());
		myList.add(3,1);
		myList.remove((Integer)5);
		

	}

}
