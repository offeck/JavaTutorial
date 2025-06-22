public class Student {
    // Fields
    private String fullName;
    private final String ID;
    private double avgGrade;
    private int daysInReserve;

    //Constructors
    public Student(String fullName, String ID, double avgGrade, int daysInReserve) {
        this.fullName = fullName;
        this.ID = ID;
        this.avgGrade = avgGrade;
        this.daysInReserve = daysInReserve;
    }

    public Student(String fullName, String ID) {
        this(fullName, ID, 0.0, 0);
    }


    //Methods
    public String getFullName() {
        return this.fullName;
    }

    public String getID() {
        return this.ID;
    }

    public double getAvgGrade() {
        return this.avgGrade;
    }

    public int getDaysInReserve() {
        return this.daysInReserve;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int addDaysInReserve(int daysToAdd) {
        if (daysToAdd >= 0)
            this.daysInReserve = getDaysInReserve() + daysToAdd;
        return getDaysInReserve();
    }

    public void resetDaysInReserve() {
        this.daysInReserve = 0;
    }

    @Override
    public String toString() {
        return "(" + getFullName() + ", " + getID() + ", " + getAvgGrade() + ", " + getDaysInReserve() + ")";
    }

    @Override
    public boolean equals(Object other) {
        boolean equals = false;
        if (other instanceof Student) {
            Student otherStudent = (Student) other;
            equals = getFullName().equals(otherStudent.getFullName()) &&
                    getID().equals(otherStudent.getID()) &&
                    getAvgGrade() == otherStudent.getAvgGrade() &&
                    getDaysInReserve() == otherStudent.getDaysInReserve();
        }
        return equals;
    }
}
