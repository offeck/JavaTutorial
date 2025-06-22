import java.util.Comparator;

public class StudentAverageComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
        return (int) Math.signum(s1.getAvgGrade() - s2.getAvgGrade());
    }
}
