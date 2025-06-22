
public class OrderedIntPair {

    private final int x;
    private final int y;

    public OrderedIntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }

    @Override
    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof OrderedIntPair) {
            OrderedIntPair otherPair = (OrderedIntPair) other;
            equals = getX() == otherPair.getX() &&
                    getY() == otherPair.getY();
        }
        return equals;
    }

}
