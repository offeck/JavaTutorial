
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

    @Override
    public String toString() {
        return "(" + getFirst().toString() + ", " + getSecond().toString() + ")";
    }
    @Override
    public boolean equals(Object other) {
        boolean res = false;
        if(other instanceof OrderedPair<?,?>){
            OrderedPair<?,?> otherPair = (OrderedPair<?,?>) other;
            res = this.getFirst().equals(otherPair.getFirst()) &&
                    this.getSecond().equals(otherPair.getSecond());
        }
        return res;
    }
}
