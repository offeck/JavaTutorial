public class Date implements Comparable<Date> {

    //Fields
    private final int DAY;
    private final int MONTH;
    private final int YEAR;

    //Constructor(s)
    public Date(int DAY, int MONTH, int YEAR) {
        this.DAY = DAY;
        this.MONTH = MONTH;
        this.YEAR = YEAR;
    }

    //Methods
    public int getDAY() {
        return this.DAY;
    }

    public int getMONTH() {
        return this.MONTH;
    }

    public int getYEAR() {
        return this.YEAR;
    }

    public int compareTo(Date other) {
        int ans = 0;
        if (getYEAR() != other.getYEAR()) {
            ans = getYEAR() - other.getYEAR();
        }
        else if (getMONTH() != other.getMONTH()) {
            ans = getMONTH() - other.getMONTH();
        }
        else {
            ans = getDAY() - other.getDAY();
        }
        return ans;
    }

    @Override
    public String toString() {
        return getDAY() + "." + getMONTH() + "." + getYEAR();
    }

    @Override
    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof Date)
            equals = getDAY() == ((Date) other).getDAY() &&
                    getMONTH() == ((Date) other).getMONTH() &&
                    getYEAR() == ((Date) other).getYEAR();
        return equals;
    }
}
