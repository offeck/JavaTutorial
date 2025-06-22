import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetOperations {

    // Returns if A is subset of B
    public static <T> boolean subset(Set<T> setA, Set<T> setB) {
        boolean isSubset = true;
        Iterator<T> iterB = setB.iterator();
        while (iterB.hasNext() & isSubset) {
            isSubset = setA.contains(iterB.next());
        }
        return isSubset;
    }

    // Returns A union B
    public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> union = new SetAsDynamicArray<>();
        Iterator<T> iterA = setA.iterator();
        Iterator<T> iterB = setB.iterator();
        while (iterA.hasNext()) {
            union.add(iterA.next());
        }
        while (iterB.hasNext()) {
            union.add(iterB.next());
        }
        return union;
    }

	/*
	// Returns A union B
	public static <T> Set<T> union(Set<T> setA, Set<T> setB) {
        Set<T> union = new SetAsDynamicArray<>();
        for (T element: setA){
            union.add(element);
        }
        for (T element: setB){
            union.add(element);
        }
        return union;
    } */

    //Returns A intersection B
    public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> intersection = new SetAsDynamicArray<>();
        Iterator<T> iterA = setA.iterator();
        while (iterA.hasNext()) {
            T element = iterA.next();
            if (setB.contains(element))
                intersection.add(element);
        }
        return intersection;
    }

	/*
	//Returns A intersection B
	public static <T> Set<T> intersection(Set<T> setA, Set<T> setB) {
        Set<T> intersection = new SetAsDynamicArray<>();
        for (T element: setA){
            if (setB.contains(element))
                intersection.add(element);
        }
        return intersection;
    } */

    // Returns A subtraction B
    public static <T> Set<T> subtraction(Set<T> setA, Set<T> setB) {
        Set<T> subtraction = new SetAsDynamicArray<>();
        Iterator<T> iterSetA = setA.iterator();
        while (iterSetA.hasNext()) {
            T element = iterSetA.next();
            if (!setB.contains(element))
                subtraction.add(element);
        }
        return subtraction;
    }

	/*
	//Returns A subtraction B
	public static <T> Set<T> subtraction(Set<T> setA, Set<T> setB) {
        Set<T> subtraction = new SetAsDynamicArray<>();
        for (T element: setA){
            if (!setB.contains(element))
                subtraction.add(element);
        }
        return subtraction;
    } */

    public static <T> Set<T> unionAll(Set<Set<T>> sets) {
        Set<T> union = new SetAsLinkedList<T>();

        Iterator<Set<T>> setsIter = sets.iterator();
        while (setsIter.hasNext()) {
            Set<T> currentSet = setsIter.next();
            Iterator<T> currentIter = currentSet.iterator();
            while (currentIter.hasNext()) {
                union.add(currentIter.next());
            }
        }
        return union;
    }

    //return the minimal item in the set.
    public static <T extends Comparable<T>> T findMin(Set<T> set) {
        if (set.isEmpty())
            throw new NoSuchElementException();

        Iterator<T> it = set.iterator();
        T minElement = it.next();

        while (it.hasNext()) {
            T nextElement = it.next();
            if (minElement.compareTo(nextElement) > 0)
                minElement = nextElement;
        }
        return minElement;
    }

    //return the minimal item in the set.
    public static <T> T findMin(Set<T> set, Comparator<T> comparator) {
        if (set == null | comparator == null)
            throw new IllegalArgumentException();
        if (set.isEmpty())
            throw new NoSuchElementException();

        Iterator<T> it = set.iterator();
        T minElement = it.next();

        while (it.hasNext()) {
            T nextElement = it.next();
            if (comparator.compare(minElement, nextElement) > 0)
                minElement = nextElement;
        }
        return minElement;
    }

    //Returns A difference B (A\B)
    public static <T> Set<T> difference(Set<T> setA, Set<T> setB) {
        Set<T> dif = new SetAsDynamicArray<>();
        Iterator<T> iterSetA = setA.iterator();
        while (iterSetA.hasNext()) {
            T element = iterSetA.next();
            if (!setB.contains(element)) {
                dif.add(element);
            }
        }
        return dif;
    }

    // Returns A symmetric difference B (AΔB)
    public static <T> Set<T> symmetricDifference(Set<T> setA, Set<T> setB) {
        return difference(union(setA, setB), intersection(setA, setB));
    }

    // Given a set A and an element x - the function returns A\{x}
    public static <T> Set<T> removeOneElement(Set<T> setA, T element) {
        Set<T> toRemoveSingleton = new SetAsDynamicArray<>();
        toRemoveSingleton.add(element);

        return difference(setA, toRemoveSingleton);
    }

    // Returns a new set of sets which is the given setOfSets where addMe was added to every set in setOfSets
    public static <T> Set<Set<T>> addToAll(Set<Set<T>> setOfSets, T addMe) {
        Set<Set<T>> output = new SetAsDynamicArray<Set<T>>();
        Iterator<Set<T>> it = setOfSets.iterator();
        Set<T> addMeSingleton = new SetAsDynamicArray<T>();
        addMeSingleton.add(addMe);
        // iterate over each set in setOfSets
        while (it.hasNext()) {
            output.add(union(it.next(), addMeSingleton));
        }
        return output;
    }

    // Calculates and returns the powerset of setA = P(A)
    public static <T> Set<Set<T>> powerSet(Set<T> setA) {
        Set<Set<T>> output;
        if (setA.isEmpty()) {
            output = new SetAsDynamicArray<>();
            output.add(new SetAsDynamicArray<>());
        } else {
            T element = setA.iterator().next();                             // x
            Set<T> setAWithoutElement = removeOneElement(setA, element);    // A\{x}
            // Calculate and return the power-set of setA\{x}
            Set<Set<T>> powerSetWithout = powerSet(setAWithoutElement);     // P(A\{x})
            Set<Set<T>> powerSetWith = addToAll(powerSetWithout, element);  // {B U {x} | B∈ P(A\{x}) }
            output = SetOperations.union(powerSetWith, powerSetWithout);    // P(A\{x}) U {B U {x} | B∈ P(A\{x}) }
        }
        return output;
    }

    // Returns AxB
    public static <T1, T2> Set<OrderedPair<T1, T2>> cartesianProduct(Set<T1> setA, Set<T2> setB) {
        Set<OrderedPair<T1, T2>> prod = new SetAsDynamicArray<>();

        Iterator<T1> iterA = setA.iterator();
        while (iterA.hasNext()) {
            T1 a = iterA.next();
            Iterator<T2> iterB = setB.iterator();
            while (iterB.hasNext())
                prod.add(new OrderedPair<>(a, iterB.next()));
        }
        return prod;
    }

    // Returns max{A}
    public static <T extends Comparable<T>> T getMax(Set<T> setA) {
        if (setA.isEmpty()) {
            return null;
        }
        Iterator<T> iter = setA.iterator();
        T max = iter.next();
        while (iter.hasNext()) {
            T curr = iter.next();
            if (max.compareTo(curr) < 0) {
                max = curr;
            }
        }
        return max;
    }

}
