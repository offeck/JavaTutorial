import java.util.Iterator;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BSTPathIterator<T> implements Iterator<T> {
    private BinarySearchNode <T> next;
    private T findMe;

    public BSTPathIterator(BinarySearchNode<T> node, T findMe){
        this.next = node;
        this.findMe = findMe;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T next(){
        T nextData;
        if (!hasNext())
            throw new NoSuchElementException();
        nextData = next.data;
        Comparator<T> comp = next.getComparator();
        int diff = comp.compare(nextData, findMe);
        if (diff == 0)
            next = null;
        else if(diff < 0)
            next = (BinarySearchNode<T>)next.right;
        else
            next = (BinarySearchNode<T>)next.left;
        return nextData;
    }

}
