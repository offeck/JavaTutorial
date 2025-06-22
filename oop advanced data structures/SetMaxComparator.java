import java.util.Comparator;

public class SetMaxComparator<T extends Comparable<T>> implements Comparator<Set<T>> {

    public int compare(Set<T> setA, Set<T> setB) {
        if (setA == null || setB == null) {
            throw new IllegalArgumentException("Sets can't be null");
        }
        int ans = 0;
        T maxA = SetOperations.getMax(setA);
        T maxB = SetOperations.getMax(setB);
        if (maxA == null) {
            if (maxB == null)
                ans = 0;
            else
                ans = -1;
        }
        else if (maxB == null)
            ans = 1;
        else ans = maxA.compareTo(maxB);

        return ans;
    }
}
