import java.util.Iterator;
import java.util.NoSuchElementException;

public class FilterIterator<T> implements Iterator<T> {

    private Filter<T> filter;
    private Iterator<T> iter;
    private T next;

    public FilterIterator(Filter<T> filter, Iterator<T> iter) {
        this.filter = filter;
        this.iter = iter;
        next = findNext();
    }

    @Override
    public boolean hasNext() {
        return (next != null);
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();
        T temp = this.next;
        next = findNext();
        return temp;

    }

    /* ───────────────────────────────────────── */

    /** Placeholder so the file compiles; fill in real logic later. */
    private T findNext() {
        T temp = iter.next();
        while (iter.hasNext()) {
            if (filter.accept(temp)) {
                return temp;
            } else {
                temp = iter.next();
            }
        }
        return null;

    }

    /** Minimal Filter definition so the file compiles. */
    public interface Filter<E> {
        boolean accept(E item);
    }
}
