import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreePreOrderIterator<T> implements Iterator<T>{
	private Stack<BinaryNode<T>> stack;
 
	public BinaryTreePreOrderIterator(BinaryNode<T> root) {
		stack = new StackAsDynamicArray<>();
		stack.push(root);
	}
 
	public boolean hasNext() {
		return !stack.isEmpty();
	}
 
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		BinaryNode<T> node = (BinaryNode<T>)(stack.pop());
		if (node.right != null) {
			stack.push(node.right);
		}
		if (node.left != null) {
			stack.push(node.left);
		}
		return node.data;
	}

}
