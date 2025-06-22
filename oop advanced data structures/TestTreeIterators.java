import java.util.Iterator;

public class TestTreeIterators {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>() ;

		tree.insert(15);
		tree.insert(9);
		tree.insert(2);
		tree.insert(7);
		tree.insert(4);
		tree.insert(5);
		tree.insert(19);
		tree.insert(3);

		Iterator<Integer> inOrderIter = tree.inOrderIterator();
		while(inOrderIter.hasNext()) {
			System.out.print(inOrderIter.next() + " ");
		}
		System.out.println();

		Iterator<Integer> bfsIter = tree.bfsIterator() ;
		while(bfsIter.hasNext()) {
			System.out.print(bfsIter.next() + " ");
		}
		System.out.println();

	}

}
