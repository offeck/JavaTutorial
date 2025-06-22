public class OrderedPair<T1, T2> {
    //Fields
    private final T1 first;
    private final T2 second;

    //Constructors
    public OrderedPair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    //Methods
    public T1 getFirst() {
        return this.first;
    }

    public T2 getSecond() {
        return this.second;
    }

    public String toString() {
        return "(" + getFirst().toString() + ", " + getSecond().toString() + ")";
    }

    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof OrderedPair<?, ?>) {
            OrderedPair<?, ?> otherPair = (OrderedPair<?, ?>) other;
            equals = getFirst() == otherPair.getFirst() &
                    getSecond() == otherPair.getSecond();
        }
        return equals;
    }
}
